package com.jj.ekklesia.service.ministry

import com.jj.ekklesia.dto.ministry.MinistryRequestDTO
import com.jj.ekklesia.dto.ministry.MinistryResponseDTO
import com.jj.ekklesia.dto.ministry.SimpleMemberDTO
import com.jj.ekklesia.exception.ResourceNotFoundException
import com.jj.ekklesia.model.Member
import com.jj.ekklesia.model.Ministry
import com.jj.ekklesia.repository.MemberRepository
import com.jj.ekklesia.repository.MinistryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class MinistryServiceImpl(
    private val ministryRepository: MinistryRepository,
    private val memberRepository: MemberRepository
): MinistryService {
    override fun createMinistry(ministryRequestDTO: MinistryRequestDTO): MinistryResponseDTO {
        val members = memberRepository.findAllById(ministryRequestDTO.memberIds)
        val leaders = memberRepository.findAllById(ministryRequestDTO.leaderIds)
        verifyIfMemberIsMinistryLeader(leaders)


        val ministry = Ministry(
            name = ministryRequestDTO.name,
            members = members.toMutableSet(),
            leaders = leaders.toMutableSet()
        )

        val saved = ministryRepository.save(ministry)
        return toResponseDTO(saved)
    }

    override fun updateMinistry(id: UUID, ministryRequestDTO: MinistryRequestDTO): MinistryResponseDTO {
        val ministry = ministryRepository.findById(id).orElseThrow {
            throw ResourceNotFoundException("Ministério não encontrado")
        }
        val members = memberRepository.findAllById(ministryRequestDTO.memberIds)
        val leaders = memberRepository.findAllById(ministryRequestDTO.leaderIds)
        val updatedMinitry = Ministry(id = ministry.id, name = ministryRequestDTO.name, leaders = leaders.toMutableSet(), members = members.toMutableSet())
        ministryRepository.save(updatedMinitry)
        return toResponseDTO(updatedMinitry)
    }

    override fun deleteMinistry(id: UUID): Boolean {
        val ministry = ministryRepository.findById(id).orElseThrow {
            throw ResourceNotFoundException("Ministério não encontrado")
        }
        ministryRepository.delete(ministry)
        return true;
    }

    override fun getAllMinistries(): List<MinistryResponseDTO> {
        return ministryRepository.findAll().map { toResponseDTO(it) }
    }

    override fun getMinistryById(id: UUID): MinistryResponseDTO {
        val ministery = ministryRepository.findById(id).orElseThrow {
            throw ResourceNotFoundException("Ministério não encontrado")
        }
        return toResponseDTO(ministery);
    }

    private fun toResponseDTO(ministry: Ministry): MinistryResponseDTO {
        return MinistryResponseDTO(
            id = ministry.id!!,
            name = ministry.name,
            members = ministry.members.map { it.toSimpleDTO() },
            leaders = ministry.leaders.map { it.toSimpleDTO() }
        )
    }

    private fun Member.toSimpleDTO(): SimpleMemberDTO {
        return SimpleMemberDTO(
            id = this.id!!,
            name = this.person.name,
            email = this.person.email
        )
    }

    private fun verifyIfMemberIsMinistryLeader(members: List<Member>) {
        members.forEach {
            if (it.memberRole.id != 5L) {
                throw IllegalArgumentException("O membro ${it.person.name} não possui o cargo de 'Líder de Ministério'")
            }
        }
    }


}