package com.jj.ekklesia.dto.member

import com.jj.ekklesia.dto.person.PersonRequestDTO


class MemberRequestDTO(
    name: String,
    email: String,
    password: String,
    age: Int,
    val memberRole: Long
) : PersonRequestDTO(name, email, password, age)
