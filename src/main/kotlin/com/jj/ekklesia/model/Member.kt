package com.jj.ekklesia.model

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "members")
data class Member (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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