package com.jj.ekklesia.dto

import java.util.UUID

data class MemberResponseDTO(
    val id: UUID?,
    val name: String,
    val age: Int,
    val email: String
)
