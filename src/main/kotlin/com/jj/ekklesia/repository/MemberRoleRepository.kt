package com.jj.ekklesia.repository

import com.jj.ekklesia.model.MemberRole
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MemberRoleRepository : JpaRepository<MemberRole, Long> {
    fun findByName(name: String): MemberRole?
}
