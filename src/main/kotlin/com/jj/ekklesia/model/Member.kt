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
    @AttributeOverrides(
        AttributeOverride(name = "email", column = Column(name = "email", unique = true))
    )
    var person: Person,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    var memberRole: MemberRole,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "church_id", nullable = false)
    var church: Church
)
