package com.jj.ekklesia.model

import jakarta.persistence.Embeddable

@Embeddable
data class Person(
    val name: String,
    val email: String,
    val age: Int,
    val password: String
)
