package com.jj.ekklesia.model

import java.util.UUID


data class Member (
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val age: Int,
    val email: String,
    val password: String,
)