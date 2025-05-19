package com.jj.ekklesia.service.church

import org.springframework.transaction.annotation.Transactional

import com.jj.ekklesia.dto.church.ChurchRequestDTO
import com.jj.ekklesia.dto.church.ChurchResponseDTO
import com.jj.ekklesia.dto.church.MemberSummaryDTO
import com.jj.ekklesia.model.Church
import com.jj.ekklesia.repository.ChurchRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
@Transactional
class ChurchServiceImpl(
    private val churchRepository: ChurchRepository
): ChurchService {

    override fun getAllChurch(): List<ChurchResponseDTO> {
        return churchRepository.findAll().map { toResponseDTO(it) }
    }

    override fun getChurchById(id: UUID): ChurchResponseDTO {
        val church = churchRepository.findById(id)
            .orElseThrow { NoSuchElementException("Igreja com id $id não encontrada.") }
        return toResponseDTO(church)
    }

    override fun createChurch(churchRequestDTO: ChurchRequestDTO): ChurchResponseDTO {
        val church = Church(
            name = churchRequestDTO.name,
            zipCode = churchRequestDTO.zipCode,
            region = churchRequestDTO.region
        )
        val saved = churchRepository.save(church)
        return toResponseDTO(saved)
    }

    override fun updateChurch(id: UUID, churchRequestDTO: ChurchRequestDTO): ChurchResponseDTO {
        val existing = churchRepository.findById(id)
            .orElseThrow { NoSuchElementException("Igreja com id $id não encontrada.") }

        val updated = Church(
            id = existing.id,
            name = churchRequestDTO.name,
            zipCode = churchRequestDTO.zipCode,
            region = churchRequestDTO.region
        )
        val saved = churchRepository.save(updated)
        return toResponseDTO(saved)
    }

    override fun deleteChurch(id: UUID): Boolean {
        if (!churchRepository.existsById(id)) {
            throw NoSuchElementException("Igreja com id $id não encontrada.")
        }
        churchRepository.deleteById(id)
        return true
    }

    private fun toResponseDTO(church: Church): ChurchResponseDTO {
        return ChurchResponseDTO(
            id = church.id!!,
            name = church.name,
            zipCode = church.zipCode,
            region = church.region,
            members = church.members.map {
                MemberSummaryDTO(
                    id = it.id!!,
                    name = it.person.name,
                    role = it.memberRole.name
                )
            }
        )
    }
}
