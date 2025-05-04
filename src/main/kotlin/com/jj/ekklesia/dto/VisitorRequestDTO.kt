package com.jj.ekklesia.dto

class VisitorRequestDTO(
    name: String,
    email: String,
    password: String,
    age: Int,
    val visitPurpose: String
) : PersonRequestDTO(name, email, password, age)
