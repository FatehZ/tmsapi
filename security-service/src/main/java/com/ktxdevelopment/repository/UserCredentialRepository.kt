package com.ktxdevelopment.repository

import com.ktxdevelopment.entity.UserCredential
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserCredentialRepository : JpaRepository<UserCredential?, Int?> {
    fun findByName(username: String?): Optional<UserCredential>
}
