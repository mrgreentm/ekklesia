package com.jj.ekklesia.controller
import com.jj.ekklesia.dto.visitor.VisitorRequestDTO
import com.jj.ekklesia.dto.visitor.VisitorResponseDTO
import com.jj.ekklesia.service.visitor.VisitorService
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
    fun createVisitor(@RequestBody visitorRequestDTO: VisitorRequestDTO): ResponseEntity<VisitorResponseDTO> {
        val createdMember = visitorService.createVisitor(visitorRequestDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMember)
    }

    @PutMapping("/{id}")
    fun updateVisitor(
        @PathVariable id: UUID,
        @RequestBody visitorRequestDTO: VisitorRequestDTO
    ): ResponseEntity<VisitorResponseDTO> {
        return ResponseEntity.ok(visitorService.updateVisitor(id, visitorRequestDTO))
    }

    @DeleteMapping("/{id}")
    fun deleteVisitor(@PathVariable id: UUID): ResponseEntity<Void> {
        return if (visitorService.deleteVisitor(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
