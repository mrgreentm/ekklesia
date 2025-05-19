package com.jj.ekklesia.dto.church

import java.util.*

data class ChurchResponseDTO(
    val id: UUID,
    val name: String,
    val zipCode: String,
    val region: String,
    val members: List<MemberSummaryDTO> = emptyList()
)

data class MemberSummaryDTO(
    val id: UUID,
    val name: String,
    val role: String
)
