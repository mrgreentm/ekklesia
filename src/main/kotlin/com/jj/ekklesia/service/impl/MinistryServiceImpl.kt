package com.jj.ekklesia.service.impl

import com.jj.ekklesia.dto.MinistryRequestDTO
import com.jj.ekklesia.dto.MinistryResponseDTO
import com.jj.ekklesia.dto.SimpleMemberDTO
import com.jj.ekklesia.model.Member
import com.jj.ekklesia.model.Ministry
import com.jj.ekklesia.repository.MemberRepository
import com.jj.ekklesia.repository.MinistryRepository
import com.jj.ekklesia.service.MinistryService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MinistryServiceImpl(
    private val ministryRepository: MinistryRepository,
    private val memberRepository: MemberRepository
): MinistryService {
    override fun createMinistry(ministryRequestDTO: MinistryRequestDTO): MinistryResponseDTO {
        val members = memberRepository.findAllById(ministryRequestDTO.memberIds)
        val leaders = memberRepository.findAllById(ministryRequestDTO.leaderIds)
        this.verifyIfMemberIsMinisteryLeader(leaders)


        val ministry = Ministry(
            name = ministryRequestDTO.name,
            members = members.toMutableSet(),
            leaders = leaders.toMutableSet()
        )

        val saved = ministryRepository.save(ministry)
        return toResponseDTO(saved)
    }

    override fun getAllMinistries(): List<MinistryResponseDTO> {
        return ministryRepository.findAll().map { toResponseDTO(it) }
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

    private fun verifyIfMemberIsMinisteryLeader(members: List<Member>) {
        members.forEach {
            if (it.memberRole.id != 5L) {
                throw IllegalArgumentException("O membro ${it.person.name} não possui o cargo de 'Líder de Ministério'")
            }
        }
    }


}