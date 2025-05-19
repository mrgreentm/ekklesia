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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    var memberRole: MemberRole
)
