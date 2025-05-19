package com.jj.ekklesia.controller

import com.jj.ekklesia.dto.church.ChurchRequestDTO
import com.jj.ekklesia.dto.church.ChurchResponseDTO
import com.jj.ekklesia.service.church.ChurchService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/churches")
class ChurchController(private val churchService: ChurchService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createChurch(@RequestBody dto: ChurchRequestDTO): ChurchResponseDTO {
        return churchService.createChurch(dto)
    }

    @PutMapping("/{id}")
    fun updateChurch(
        @PathVariable id: UUID,
        @RequestBody dto: ChurchRequestDTO
    ): ResponseEntity<ChurchResponseDTO> {
        return ResponseEntity.ok(churchService.updateChurch(id, dto))
    }

    @DeleteMapping("/{id}")
    fun deleteChurch(@PathVariable id: UUID): ResponseEntity<Void> {
        return if (churchService.deleteChurch(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping
    fun listAllChurches(): List<ChurchResponseDTO> {
        return churchService.getAllChurch()
    }

    @GetMapping("/{id}")
    fun getChurchById(@PathVariable id: UUID): ResponseEntity<ChurchResponseDTO> {
        return ResponseEntity.ok(churchService.getChurchById(id))
    }
}
