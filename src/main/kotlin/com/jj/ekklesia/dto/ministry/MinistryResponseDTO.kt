package com.jj.ekklesia.dto.ministry

import java.util.*

data class MinistryResponseDTO(
    val id: UUID,
    val name: String,
    val members: List<SimpleMemberDTO>,
    val leaders: List<SimpleMemberDTO>
)

data class SimpleMemberDTO(
    val id: UUID,
    val name: String,
    val email: String
)
