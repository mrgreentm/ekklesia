package com.jj.ekklesia.service.visitor

import com.jj.ekklesia.dto.visitor.VisitorRequestDTO
import com.jj.ekklesia.dto.visitor.VisitorResponseDTO
import com.jj.ekklesia.exception.ResourceNotFoundException
import com.jj.ekklesia.model.Person
import com.jj.ekklesia.model.Visitor
import com.jj.ekklesia.repository.VisitorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class VisitorServiceImpl(private val visitorRepository: VisitorRepository) : VisitorService {

    override fun getAllVisitors(): List<VisitorResponseDTO> {
        return visitorRepository.findAll().map {
            VisitorResponseDTO(it.id!!, it.person.name, it.person.email, it.person.age, it.visitPurpose)
        }
    }

    override fun getVisitorById(id: UUID): VisitorResponseDTO {
        val visitor = visitorRepository.findById(id).orElseThrow {
            RuntimeException("Visitante não encontrado")
        }
        return VisitorResponseDTO(visitor.id!!, visitor.person.name, visitor.person.email, visitor.person.age, visitor.visitPurpose)
    }

    override fun createVisitor(visitorRequestDTO: VisitorRequestDTO): VisitorResponseDTO {
        val visitor = Visitor(person = Person(
            name = visitorRequestDTO.name,
            email = visitorRequestDTO.email,
            age = visitorRequestDTO.age,
            password = visitorRequestDTO.password
        ), visitPurpose = visitorRequestDTO.visitPurpose)
        val savedVisitor = visitorRepository.save(visitor)
        return VisitorResponseDTO(savedVisitor.id!!, savedVisitor.person.name, savedVisitor.person.email, savedVisitor.person.age, savedVisitor.visitPurpose)
    }

    override fun updateVisitor(id: UUID, visitorRequestDTO: VisitorRequestDTO): VisitorResponseDTO {
        val visitor = visitorRepository.findById(id).orElseThrow {
            ResourceNotFoundException("Visitante não encontrado")
        }
        visitor.person = Person(visitorRequestDTO.name, visitorRequestDTO.email, visitorRequestDTO.age, visitorRequestDTO.password)
        visitor.visitPurpose = visitorRequestDTO.visitPurpose
        visitorRepository.save(visitor)
        return VisitorResponseDTO(
            id = visitor.id!!,
            name = visitor.person.name,
            email = visitor.person.email,
            visitPurpose = visitor.visitPurpose,
            age =  visitor.person.age
        )
    }


    override fun deleteVisitor(id: UUID): Boolean {
        val visitor = visitorRepository.findById(id).orElseThrow {
            ResourceNotFoundException("Visitante não encontrado")
        }
        visitorRepository.delete(visitor)
        return true
    }
}
