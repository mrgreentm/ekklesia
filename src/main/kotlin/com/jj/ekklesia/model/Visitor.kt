package com.jj.ekklesia.model

import jakarta.persistence.*
import java.util.*

@Entity
class Visitor(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,

    @Embedded
    val person: Person,

    @Column(nullable = false)
    val visitPurpose: String
)
