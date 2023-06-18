package com.ktxdevelopment.service

import com.ktxdevelopment.entity.UserCredential
import com.ktxdevelopment.repository.UserCredentialRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService {
    @Autowired
    private val repository: UserCredentialRepository? = null

    @Autowired
    private val passwordEncoder: PasswordEncoder? = null

    @Autowired
    private val jwtService: JwtService? = null
    fun saveUser(credential: UserCredential): String {
        credential.setPassword(passwordEncoder!!.encode(credential.getPassword()))
        repository.save(credential)
        return "user added to the system"
    }

    fun generateToken(username: String?): String {
        return jwtService.generateToken(username)
    }

    fun validateToken(token: String?) {
        jwtService.validateToken(token)
    }
}