package com.jj.ekklesia.dto

import com.jj.ekklesia.model.MemberRole

class MemberRequestDTO(
    name: String,
    email: String,
    password: String,
    age: Int,
    val memberRole: MemberRole
) : PersonRequestDTO(name, email, password, age)
