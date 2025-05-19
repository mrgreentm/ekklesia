package com.jj.ekklesia.dto.visitor

import com.jj.ekklesia.dto.person.PersonResponseDTO
import java.util.*

class VisitorResponseDTO(
    id: UUID,
    name: String,
    email: String,
    age: Int,
    val visitPurpose: String
) : PersonResponseDTO(id, name, email, age)
