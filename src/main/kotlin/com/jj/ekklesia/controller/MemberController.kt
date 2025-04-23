package com.jj.ekklesia.controller

import com.jj.ekklesia.dto.MemberRequestDTO
import com.jj.ekklesia.dto.MemberResponseDTO
import com.jj.ekklesia.service.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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

    @PutMapping("members/{memberId}")
    fun updateMember(@PathVariable memberId: String, @RequestBody memberRequestDTO: MemberRequestDTO): ResponseEntity<MemberResponseDTO> {
        val updatedMember = memberService.updateMember(memberId, memberRequestDTO)
        return ResponseEntity.ok(updatedMember)
    }

    @DeleteMapping("members/{memberId}")
    fun deleteMember(@PathVariable memberId: String): ResponseEntity<Void> {
        return if(memberService.deleteMember(memberId)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}