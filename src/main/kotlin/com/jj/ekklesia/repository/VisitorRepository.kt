package com.jj.ekklesia.repository

import com.jj.ekklesia.model.Visitor
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface VisitorRepository : JpaRepository<Visitor, UUID>
