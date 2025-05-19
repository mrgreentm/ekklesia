package com.jj.ekklesia.dto.visitor

import com.jj.ekklesia.dto.person.PersonRequestDTO

class VisitorRequestDTO(
    name: String,
    email: String,
    password: String,
    age: Int,
    val visitPurpose: String
) : PersonRequestDTO(name, email, password, age)
