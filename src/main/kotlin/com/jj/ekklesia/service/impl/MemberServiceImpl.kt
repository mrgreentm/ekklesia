package com.jj.ekklesia.service.impl

import com.jj.ekklesia.dto.MemberRequestDTO
import com.jj.ekklesia.dto.MemberResponseDTO
import com.jj.ekklesia.model.Member
import com.jj.ekklesia.model.Person
import com.jj.ekklesia.repository.MemberRepository
import com.jj.ekklesia.service.MemberService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class MemberServiceImpl(private val memberRepository: MemberRepository) : MemberService {

    override fun getAllMembers(): List<MemberResponseDTO> {
        return memberRepository.findAll().map {
            MemberResponseDTO(it.id!!, it.person.name, it.person.email, it.person.age, it.membershipStatus)
        }
    }

    override fun getMemberById(id: UUID): MemberResponseDTO {
        val member = memberRepository.findById(id).orElseThrow {
            RuntimeException("Membro não encontrado")
        }
        return MemberResponseDTO(member.id!!, member.person.name, member.person.email, member.person.age, member.membershipStatus)
    }

    override fun createMember(memberRequest: MemberRequestDTO): MemberResponseDTO {
        val member = Member(person = Person(
            name = memberRequest.name,
            email = memberRequest.email,
            age = memberRequest.age,
            password = memberRequest.password
        ), membershipStatus = memberRequest.membershipStatus)
        val savedMember = memberRepository.save(member)
        return MemberResponseDTO(savedMember.id!!, savedMember.person.name, savedMember.person.email, savedMember.person.age, savedMember.membershipStatus)
    }


    override fun deleteMember(id: UUID): Boolean {
        val member = memberRepository.findById(id).orElseThrow {
            RuntimeException("Membro não encontrado")
        }
        memberRepository.delete(member)
        return true
    }
}
