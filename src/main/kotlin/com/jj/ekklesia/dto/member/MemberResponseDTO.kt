package com.jj.ekklesia.dto.member

import com.jj.ekklesia.dto.church.ChurchResponseDTO
import com.jj.ekklesia.dto.person.PersonResponseDTO
import com.jj.ekklesia.model.Church
import com.jj.ekklesia.model.MemberRole
import java.util.*

class MemberResponseDTO(
    id: UUID,
    name: String,
    email: String,
    age: Int,
    val memberRole: MemberRole,
    val church: ChurchResponseDTO
) : PersonResponseDTO(id, name, email, age)
