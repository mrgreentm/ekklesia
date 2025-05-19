package com.jj.ekklesia.controller

import com.jj.ekklesia.dto.MinistryRequestDTO
import com.jj.ekklesia.dto.MinistryResponseDTO
import com.jj.ekklesia.service.MinistryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/ministries")
class MinistryController(private val ministryService: MinistryService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createMinistry(@RequestBody dto: MinistryRequestDTO): MinistryResponseDTO {
        return ministryService.createMinistry(dto)
    }

    @PutMapping("/{id}")
    fun updateMinistry(
        @PathVariable id: UUID,
        @RequestBody ministryRequestDTO: MinistryRequestDTO
    ): ResponseEntity<MinistryResponseDTO> {
        return ResponseEntity.ok(ministryService.updateMinistry(id, ministryRequestDTO))
    }

    @DeleteMapping("/{id}")
    fun deleteMinistry(@PathVariable id: UUID): ResponseEntity<Void> {
        return if (ministryService.deleteMinistry(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
    @GetMapping
    fun listAllMinistries(): List<MinistryResponseDTO> {
        return ministryService.getAllMinistries()
    }
}
