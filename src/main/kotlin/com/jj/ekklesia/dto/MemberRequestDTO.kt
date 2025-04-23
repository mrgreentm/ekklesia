package com.jj.ekklesia.dto

import jakarta.validation.constraints.*
import org.hibernate.validator.constraints.Length

class MemberRequestDTO(
    @field:NotBlank(message ="Nome é obrigatório")
    val name: String,

    @field:NotBlank(message ="Senha é obrigatória")
    @field:Length(min= 8)
    val password: String,

    @field:NotBlank(message ="Idade é obrigatória")
    @field:Min(0)
    @field:Max(120)
    val age: Int,

    @field:Email(message = "Email inválido")
    val email: String

)