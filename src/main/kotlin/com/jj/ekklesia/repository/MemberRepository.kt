package com.jj.ekklesia.repository

import com.jj.ekklesia.model.Member
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MemberRepository : JpaRepository<Member, UUID>