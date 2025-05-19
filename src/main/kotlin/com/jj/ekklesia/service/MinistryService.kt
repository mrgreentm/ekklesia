package com.jj.ekklesia.service

import com.jj.ekklesia.dto.MinistryRequestDTO
import com.jj.ekklesia.dto.MinistryResponseDTO
import java.util.*

interface MinistryService {
    fun getAllMinistries(): List<MinistryResponseDTO>
    fun getMinistryById(id: UUID): MinistryResponseDTO
    fun createMinistry(ministryRequestDTO: MinistryRequestDTO): MinistryResponseDTO
    fun updateMinistry(id: UUID, ministryRequestDTO: MinistryRequestDTO): MinistryResponseDTO
    fun deleteMinistry(id: UUID): Boolean
}