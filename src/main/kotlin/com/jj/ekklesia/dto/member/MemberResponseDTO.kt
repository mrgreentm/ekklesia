package com.jj.ekklesia.dto.member

import com.jj.ekklesia.dto.person.PersonResponseDTO
import com.jj.ekklesia.model.MemberRole
import java.util.*

class MemberResponseDTO(
    id: UUID,
    name: String,
    email: String,
    age: Int,
    val memberRole: MemberRole
) : PersonResponseDTO(id, name, email, age)
