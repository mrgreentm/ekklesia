package com.jj.ekklesia.mapper

import com.jj.ekklesia.dto.MemberRequestDTO
import com.jj.ekklesia.dto.MemberResponseDTO
import com.jj.ekklesia.model.Member
import java.util.*

object MemberMapper {
    fun toDTO(entity: Member): MemberResponseDTO = MemberResponseDTO(
        id = entity.id,
        name = entity.name,
        age = entity.age,
        email = entity.email
    )

    fun toEntity(memberRequestDTO: MemberRequestDTO): Member = Member(
        id = UUID.randomUUID(),
        name = memberRequestDTO.name,
        password = memberRequestDTO.password,
        email = memberRequestDTO.email,
        age = memberRequestDTO.age
    )
}
