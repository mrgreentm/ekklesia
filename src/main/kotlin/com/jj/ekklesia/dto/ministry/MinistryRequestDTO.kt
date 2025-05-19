package com.jj.ekklesia.dto.ministry

import java.util.*

data class MinistryRequestDTO(
    val name: String,
    val memberIds: List<UUID> = emptyList(),
    val leaderIds: List<UUID> = emptyList()
)
