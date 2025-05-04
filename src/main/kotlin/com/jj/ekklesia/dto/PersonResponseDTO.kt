package com.jj.ekklesia.dto

import lombok.Builder
import lombok.Data
import java.util.*


@Builder
@Data
open class PersonResponseDTO(
    val id: UUID,
    val name: String,
    val email: String,
    val age: Int
)