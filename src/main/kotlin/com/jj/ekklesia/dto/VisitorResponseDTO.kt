package com.jj.ekklesia.dto

import java.util.*

class VisitorResponseDTO(
    id: UUID,
    name: String,
    email: String,
    age: Int,
    val visitPurpose: String
) : PersonResponseDTO(id, name, email, age)
