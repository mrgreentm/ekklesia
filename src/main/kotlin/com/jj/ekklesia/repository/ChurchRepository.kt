package com.jj.ekklesia.repository

import com.jj.ekklesia.model.Church
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ChurchRepository: JpaRepository<Church, UUID> {
}