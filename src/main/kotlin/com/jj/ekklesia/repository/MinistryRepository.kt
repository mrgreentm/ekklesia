package com.jj.ekklesia.repository

import com.jj.ekklesia.model.Ministry
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface MinistryRepository: JpaRepository<Ministry, UUID> {
}