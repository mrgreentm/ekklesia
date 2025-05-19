package com.jj.ekklesia.service.member

import com.jj.ekklesia.dto.member.MemberRequestDTO
import com.jj.ekklesia.dto.member.MemberResponseDTO
import java.util.*

interface MemberService {
    fun getAllMembers(): List<MemberResponseDTO>
    fun getMemberById(id: UUID): MemberResponseDTO
    fun createMember(memberRequest: MemberRequestDTO): MemberResponseDTO
    fun updateMember(id: UUID, memberRequestDTO: MemberRequestDTO): MemberResponseDTO
    fun deleteMember(id: UUID): Boolean
}
