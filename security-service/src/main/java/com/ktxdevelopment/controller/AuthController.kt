package com.ktxdevelopment.controller

import com.ktxdevelopment.dto.AuthRequest
import com.ktxdevelopment.entity.UserCredential
import com.ktxdevelopment.service.AuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController {

    @Autowired
    private lateinit var service: AuthService

    @Autowired
    private val authenticationManager: AuthenticationManager? = null
    @PostMapping("/register")
    fun addNewUser(@RequestBody user: UserCredential?): String {
        if (user == null) throw RuntimeException("Request empty")
        return service.saveUser(credential = user)
    }

    @PostMapping("/token")
    fun getToken(@RequestBody authRequest: AuthRequest): String {
        val authenticate = authenticationManager!!.authenticate(
            UsernamePasswordAuthenticationToken(
                authRequest.username,
                authRequest.password
            )
        )
        return if (authenticate.isAuthenticated) {
            service.generateToken(authRequest.username)
        } else {
            throw RuntimeException("invalid access")
        }
    }

    @GetMapping("/validate")
    fun validateToken(@RequestParam("token") token: String?): String {
        service.validateToken(token)
        return "Token is valid"
    }
}
