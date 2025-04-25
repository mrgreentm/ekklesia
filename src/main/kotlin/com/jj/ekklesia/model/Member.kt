package com.jj.ekklesia.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "members")
data class Member (
    @Id
    @Column(nullable = false, updatable = false, columnDefinition = "CHAR(36)")
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val age: Int,

    @Column(unique = true, nullable = false)
    val email: String,

    @Column(nullable = false)
    val password: String,
)