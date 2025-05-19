package com.jj.ekklesia.dto

import java.util.*

data class MinistryRequestDTO(
    val name: String,
    val memberIds: List<UUID> = emptyList(),
    val leaderIds: List<UUID> = emptyList()
)
