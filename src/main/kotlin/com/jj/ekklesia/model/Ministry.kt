package com.jj.ekklesia.model

import jakarta.persistence.*
import java.util.*

@Entity
class Ministry(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID? = null,

    @Column(nullable = false, unique = true)
    val name: String,

    @ManyToMany
    @JoinTable(
        name = "ministry_members",
        joinColumns = [JoinColumn(name = "ministry_id")],
        inverseJoinColumns = [JoinColumn(name = "member_id")]
    )
    val members: MutableSet<Member> = mutableSetOf(),

    @ManyToMany
    @JoinTable(
        name = "ministry_leaders",
        joinColumns = [JoinColumn(name = "ministry_id")],
        inverseJoinColumns = [JoinColumn(name = "leader_id")]
    )
    val leaders: MutableSet<Member> = mutableSetOf()
)
