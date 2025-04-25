package com.jj.ekklesia.service

import com.jj.ekklesia.dto.MemberRequestDTO
import com.jj.ekklesia.dto.MemberResponseDTO
import com.jj.ekklesia.mapper.MemberMapper
import com.jj.ekklesia.model.Member
import com.jj.ekklesia.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException
import java.util.*

@Service
class MemberService(private val memberRepository: MemberRepository) {
    fun getAllMembers(): List<MemberResponseDTO> {
        return this.memberRepository.findAll().map {
            MemberMapper.toDTO(it)
        }
    }

    fun createMember(memberRequestDTO: MemberRequestDTO): MemberResponseDTO {
        val member =  Member(
            id = UUID.randomUUID(),
            name = memberRequestDTO.name,
            email = memberRequestDTO.email,
            password = memberRequestDTO.password,
            age = memberRequestDTO.age
        )
        memberRepository.save(member)
        return MemberMapper.toDTO(member)
    }

    fun updateMember(memberId: String, memberRequestDTO: MemberRequestDTO): MemberResponseDTO {
        val member = memberRepository
            .findById(UUID.fromString(memberId))
            .orElseThrow {
                RuntimeException("Membro nao encontrado")
            }
        val updatedMember = member.copy(
            name = memberRequestDTO.name,
            email = memberRequestDTO.email,
            password = memberRequestDTO.password,
            age = memberRequestDTO.age
        )

        val savedMember = memberRepository.save(updatedMember)

        return MemberMapper.toDTO(savedMember)
    }

    fun deleteMember(memberId: String): Boolean {
        memberRepository.delete(memberRepository.findById(UUID.fromString(memberId)).orElseThrow())
        return true
    }
}