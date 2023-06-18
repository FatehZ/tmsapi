package com.ktxdevelopment.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

@RestController
@RequestMapping("/auth")
class AuthController {
    @Autowired
    private val service: AuthService? = null

    @Autowired
    private val authenticationManager: AuthenticationManager? = null
    @PostMapping("/register")
    fun addNewUser(@RequestBody user: UserCredential?): String {
        return service.saveUser(user)
    }

    @PostMapping("/token")
    fun getToken(@RequestBody authRequest: AuthRequest): String {
        val authenticate = authenticationManager!!.authenticate(
            UsernamePasswordAuthenticationToken(
                authRequest.getUsername(),
                authRequest.getPassword()
            )
        )
        return if (authenticate.isAuthenticated) {
            service.generateToken(authRequest.getUsername())
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
