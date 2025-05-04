package com.jj.ekklesia.service

import com.jj.ekklesia.dto.VisitorRequestDTO
import com.jj.ekklesia.dto.VisitorResponseDTO
import java.util.*

interface VisitorService {
    fun getAllVisitors(): List<VisitorResponseDTO>
    fun getVisitorById(id: UUID): VisitorResponseDTO
    fun createVisitor(visitorRequestDTO: VisitorRequestDTO): VisitorResponseDTO
    fun updateVisitor(id: UUID, visitorRequestDTO: VisitorRequestDTO): VisitorResponseDTO
    fun deleteVisitor(id: UUID): Boolean
}
