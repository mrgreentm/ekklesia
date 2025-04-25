package com.jj.ekklesia.service.impl

import com.jj.ekklesia.dto.MemberRequestDTO
import com.jj.ekklesia.dto.MemberResponseDTO
import com.jj.ekklesia.exception.ResourceNotFoundException
import com.jj.ekklesia.mapper.MemberMapper
import com.jj.ekklesia.model.Member
import com.jj.ekklesia.repository.MemberRepository
import com.jj.ekklesia.service.MemberService
import org.springframework.stereotype.Service
import java.util.*

@Service
class MemberServiceImpl(
    private val memberRepository: MemberRepository
) : MemberService {

    override fun getAllMembers(): List<MemberResponseDTO> {
        return memberRepository.findAll().map { MemberMapper.toDTO(it) }
    }

    override fun createMember(memberRequestDTO: MemberRequestDTO): MemberResponseDTO {
        val member = Member(
            id = UUID.randomUUID(),
            name = memberRequestDTO.name,
            email = memberRequestDTO.email,
            password = memberRequestDTO.password,
            age = memberRequestDTO.age
        )
        return MemberMapper.toDTO(memberRepository.save(member))
    }

    override fun updateMember(memberId: String, memberRequestDTO: MemberRequestDTO): MemberResponseDTO {
        val member = memberRepository.findById(UUID.fromString(memberId))
            .orElseThrow { ResourceNotFoundException("Membro não encontrado") }

        val updatedMember = member.copy(
            name = memberRequestDTO.name,
            email = memberRequestDTO.email,
            password = memberRequestDTO.password,
            age = memberRequestDTO.age
        )

        return MemberMapper.toDTO(memberRepository.save(updatedMember))
    }

    override fun deleteMember(memberId: String): Boolean {
        val member = memberRepository.findById(UUID.fromString(memberId))
            .orElseThrow { RuntimeException("Membro não encontrado") }

        memberRepository.delete(member)
        return true
    }
}
