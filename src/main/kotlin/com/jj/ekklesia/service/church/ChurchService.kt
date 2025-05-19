package com.jj.ekklesia.service.church

import com.jj.ekklesia.dto.church.ChurchRequestDTO
import com.jj.ekklesia.dto.church.ChurchResponseDTO
import java.util.*

interface ChurchService {
    fun getAllChurch(): List<ChurchResponseDTO>
    fun getChurchById(id: UUID): ChurchResponseDTO
    fun createChurch(churchRequestDTO: ChurchRequestDTO): ChurchResponseDTO
    fun updateChurch(id: UUID, churchRequestDTO: ChurchRequestDTO): ChurchResponseDTO
    fun deleteChurch(id: UUID): Boolean

}