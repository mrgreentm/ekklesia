package com.jj.ekklesia.dto.member

import com.jj.ekklesia.dto.person.PersonRequestDTO
import java.util.UUID


class MemberRequestDTO(
    name: String,
    email: String,
    password: String,
    age: Int,
    val memberRole: Long,
    val churchId: UUID
) : PersonRequestDTO(name, email, password, age)
