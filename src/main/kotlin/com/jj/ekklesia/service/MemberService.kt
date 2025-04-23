package com.jj.ekklesia.service

import com.jj.ekklesia.dto.MemberRequestDTO
import com.jj.ekklesia.dto.MemberResponseDTO
import org.springframework.stereotype.Service
import java.util.*

@Service
class MemberService {
    fun getAllMembers(): List<MemberResponseDTO> {
        return listOf(
            MemberResponseDTO(UUID.randomUUID(), "João", 21, "joaonetotfm@gmail.com"),
            MemberResponseDTO(UUID.randomUUID(), "Pedro", 21, "pedro@gmail.com")
        )
    }

    fun createMember(memberRequestDTO: MemberRequestDTO): MemberResponseDTO {
        return MemberResponseDTO(
            UUID.randomUUID(),
            memberRequestDTO.name,
            memberRequestDTO.age,
            memberRequestDTO.email
        )
    }
}