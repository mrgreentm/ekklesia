package com.jj.ekklesia.controller

import com.jj.ekklesia.dto.MinistryRequestDTO
import com.jj.ekklesia.dto.MinistryResponseDTO
import com.jj.ekklesia.service.MinistryService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/ministries")
class MinistryController(private val ministryService: MinistryService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody dto: MinistryRequestDTO): MinistryResponseDTO {
        return ministryService.createMinistry(dto)
    }

    @GetMapping
    fun listAll(): List<MinistryResponseDTO> {
        return ministryService.getAllMinistries()
    }
}
