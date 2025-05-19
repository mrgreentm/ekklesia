package com.jj.ekklesia.model

import jakarta.persistence.*
import java.util.*

@Entity
class Church(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID? = null,

    val name: String,

    val zipCode: String,

    val region: String,

    @OneToMany(mappedBy = "church", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val members: List<Member> = mutableListOf()
)
