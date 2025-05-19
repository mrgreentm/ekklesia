package com.jj.ekklesia.seed

import com.jj.ekklesia.model.MemberRole
import com.jj.ekklesia.repository.MemberRoleRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class MemberRoleSeeder(
    private val memberRoleRepository: MemberRoleRepository
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val roles = listOf(
            mapOf("id" to 1L, "name" to "Pastor"),
            mapOf("id" to 2L, "name" to "Evangelista"),
            mapOf("id" to 3L, "name" to "Presbítero"),
            mapOf("id" to 4L, "name" to "Missionário"),
            mapOf("id" to 5L, "name" to "Líder de Ministério"),
            mapOf("id" to 6L, "name" to "Membro"),
        )

        roles.forEach {
            val id = it["id"] as Long
            val name = it["name"] as String
            if (!memberRoleRepository.existsById(id)) {
                val role = MemberRole(id, name)
                memberRoleRepository.save(role)
            }
        }
    }
}
