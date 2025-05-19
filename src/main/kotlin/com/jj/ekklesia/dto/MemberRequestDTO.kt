package com.jj.ekklesia.dto


class MemberRequestDTO(
    name: String,
    email: String,
    password: String,
    age: Int,
    val memberRole: Long
) : PersonRequestDTO(name, email, password, age)
