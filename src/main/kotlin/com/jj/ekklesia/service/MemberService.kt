package com.jj.ekklesia.service

import com.jj.ekklesia.dto.MemberRequestDTO
import com.jj.ekklesia.dto.MemberResponseDTO
import java.util.*

interface MemberService {
    fun getAllMembers(): List<MemberResponseDTO>
    fun getMemberById(id: UUID): MemberResponseDTO
    fun createMember(memberRequest: MemberRequestDTO): MemberResponseDTO
    fun updateMember(id: UUID, memberRequestDTO: MemberRequestDTO): MemberResponseDTO
    fun deleteMember(id: UUID): Boolean
}
