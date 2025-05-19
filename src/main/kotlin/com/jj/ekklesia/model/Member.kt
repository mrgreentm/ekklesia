package com.jj.ekklesia.model

import jakarta.persistence.*
import java.util.*

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID? = null,

    @Embedded
    var person: Person,

    @Column(nullable = false)
    var memberRole: MemberRole
)
