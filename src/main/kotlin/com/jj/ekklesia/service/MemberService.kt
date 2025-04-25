package com.jj.ekklesia.service

import com.jj.ekklesia.dto.MemberRequestDTO
import com.jj.ekklesia.dto.MemberResponseDTO

interface MemberService {
    fun getAllMembers(): List<MemberResponseDTO>
    fun createMember(memberRequestDTO: MemberRequestDTO): MemberResponseDTO
    fun updateMember(memberId: String, memberRequestDTO: MemberRequestDTO): MemberResponseDTO
    fun deleteMember(memberId: String): Boolean
}
