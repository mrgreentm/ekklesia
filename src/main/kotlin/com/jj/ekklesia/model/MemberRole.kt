package com.jj.ekklesia.model

import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "member_roles")
data class MemberRole(
    @Id
    val id: Long? = null,

    @Column(nullable = false, unique = true)
    val name: String
): Serializable
