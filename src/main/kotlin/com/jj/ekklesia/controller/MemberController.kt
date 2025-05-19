package com.jj.ekklesia.controller
import com.jj.ekklesia.dto.member.MemberRequestDTO
import com.jj.ekklesia.dto.member.MemberResponseDTO
import com.jj.ekklesia.service.member.MemberService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/members")
class MemberController(private val memberService: MemberService) {

    @GetMapping
    fun getAllMembers(): ResponseEntity<List<MemberResponseDTO>> {
        return ResponseEntity.ok(memberService.getAllMembers())
    }

    @GetMapping("/{id}")
    fun getMemberById(@PathVariable id: UUID): ResponseEntity<MemberResponseDTO> {
        return ResponseEntity.ok(memberService.getMemberById(id))
    }

    @PostMapping
    fun createMember(@RequestBody memberRequestDTO: MemberRequestDTO): ResponseEntity<MemberResponseDTO> {
        val createdMember = memberService.createMember(memberRequestDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMember)
    }

    @PutMapping("/{id}")
    fun updateMember(
        @PathVariable id: UUID,
        @RequestBody memberRequestDTO: MemberRequestDTO
    ): ResponseEntity<MemberResponseDTO> {
        return ResponseEntity.ok(memberService.updateMember(id, memberRequestDTO))
    }

    @DeleteMapping("/{id}")
    fun deleteMember(@PathVariable id: UUID): ResponseEntity<Void> {
        return if (memberService.deleteMember(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
