package com.jj.ekklesia.controller
import com.jj.ekklesia.dto.VisitorRequestDTO
import com.jj.ekklesia.dto.VisitorResponseDTO
import com.jj.ekklesia.service.VisitorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/visitors")
class VisitorController(private val visitorService: VisitorService) {

    @GetMapping
    fun getAllVisitors(): ResponseEntity<List<VisitorResponseDTO>> {
        return ResponseEntity.ok(visitorService.getAllVisitors())
    }

    @GetMapping("/{id}")
    fun getVisitorById(@PathVariable id: UUID): ResponseEntity<VisitorResponseDTO> {
        return ResponseEntity.ok(visitorService.getVisitorById(id))
    }

    @PostMapping
    fun createMember(@RequestBody visitorRequestDTO: VisitorRequestDTO): ResponseEntity<VisitorResponseDTO> {
        val createdMember = visitorService.createVisitor(visitorRequestDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMember)
    }

    @PutMapping("/{id}")
    fun updateMember(
        @PathVariable id: UUID,
        @RequestBody visitorRequestDTO: VisitorRequestDTO
    ): ResponseEntity<VisitorResponseDTO> {
        return ResponseEntity.ok(visitorService.updateVisitor(id, visitorRequestDTO))
    }

    @DeleteMapping("/{id}")
    fun deleteMember(@PathVariable id: UUID): ResponseEntity<Void> {
        return if (visitorService.deleteVisitor(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
