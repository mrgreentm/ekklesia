package com.jj.ekklesia.controller

import com.jj.ekklesia.dto.MemberRequestDTO
import com.jj.ekklesia.dto.MemberResponseDTO
import com.jj.ekklesia.service.MemberService
import feign.Response
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI


@RestController
class MemberController(private val memberService: MemberService) {

    @GetMapping("members")
    fun getAllMembers(): List<MemberResponseDTO> {
        return memberService.getAllMembers()
    }

    @PostMapping("member")
    fun createMember(@RequestBody memberRequestDTO: MemberRequestDTO): ResponseEntity<MemberResponseDTO> {
        val createdMember = memberService.createMember(memberRequestDTO)
        val location = "/members/${createdMember.id}"
        return ResponseEntity.created(URI(location)).body(createdMember)
    }
}