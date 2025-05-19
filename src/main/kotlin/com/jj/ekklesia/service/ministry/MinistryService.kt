package com.jj.ekklesia.service.ministry

import com.jj.ekklesia.dto.ministry.MinistryRequestDTO
import com.jj.ekklesia.dto.ministry.MinistryResponseDTO
import java.util.*

interface MinistryService {
    fun getAllMinistries(): List<MinistryResponseDTO>
    fun getMinistryById(id: UUID): MinistryResponseDTO
    fun createMinistry(ministryRequestDTO: MinistryRequestDTO): MinistryResponseDTO
    fun updateMinistry(id: UUID, ministryRequestDTO: MinistryRequestDTO): MinistryResponseDTO
    fun deleteMinistry(id: UUID): Boolean
}