package com.jj.ekklesia.service.impl

import com.jj.ekklesia.dto.MemberRequestDTO
import com.jj.ekklesia.dto.MemberResponseDTO
import com.jj.ekklesia.exception.ResourceNotFoundException
import com.jj.ekklesia.model.Member
import com.jj.ekklesia.model.MemberRole
import com.jj.ekklesia.model.Person
import com.jj.ekklesia.repository.MemberRepository
import com.jj.ekklesia.repository.MemberRoleRepository
import com.jj.ekklesia.service.MemberService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class MemberServiceImpl(
    private val memberRepository: MemberRepository,
    private val memberRoleRepository: MemberRoleRepository
    ) : MemberService {

    override fun getAllMembers(): List<MemberResponseDTO> {
        return memberRepository.findAll().map {
            MemberResponseDTO(it.id!!, it.person.name, it.person.email, it.person.age, it.memberRole)
        }
    }

    override fun getMemberById(id: UUID): MemberResponseDTO {
        val member = memberRepository.findById(id).orElseThrow {
            RuntimeException("Membro não encontrado")
        }
        return MemberResponseDTO(member.id!!, member.person.name, member.person.email, member.person.age, member.memberRole)
    }

    override fun createMember(memberRequest: MemberRequestDTO): MemberResponseDTO {
        val role = verifyRole(memberRequest.memberRole)
        val member = Member(person = Person(
            name = memberRequest.name,
            email = memberRequest.email,
            age = memberRequest.age,
            password = memberRequest.password
        ), memberRole = role)
        val savedMember = memberRepository.save(member)
        return MemberResponseDTO(savedMember.id!!, savedMember.person.name, savedMember.person.email, savedMember.person.age, savedMember.memberRole)
    }

    override fun updateMember(id: UUID, memberRequestDTO: MemberRequestDTO): MemberResponseDTO {
        val member = memberRepository.findById(id).orElseThrow {
            ResourceNotFoundException("Membro não encontrado")
        }
        val role = verifyRole(memberRequestDTO.memberRole)
        member.person = Person(memberRequestDTO.name, memberRequestDTO.email, memberRequestDTO.age, memberRequestDTO.password)
        member.memberRole = role
        memberRepository.save(member)
        return MemberResponseDTO(
            id = member.id!!,
            name = member.person.name,
            email = member.person.email,
            memberRole = member.memberRole,
            age =  member.person.age
        )
    }


    override fun deleteMember(id: UUID): Boolean {
        val member = memberRepository.findById(id).orElseThrow {
            ResourceNotFoundException("Membro não encontrado")
        }
        memberRepository.delete(member)
        return true
    }

    private fun verifyRole(roleId: Long): MemberRole {
        return memberRoleRepository.findById(roleId).orElseThrow {
            RuntimeException("Cargo não encontrado")
        }
    }
}
