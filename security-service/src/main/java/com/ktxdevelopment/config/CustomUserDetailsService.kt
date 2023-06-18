package com.ktxdevelopment.config

import com.javatechie.config.CustomUserDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import java.util.*
import java.util.function.Function
import java.util.function.Supplier

@Component
class CustomUserDetailsService : UserDetailsService {
    @Autowired
    private val repository: UserCredentialRepository? = null

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val credential: Optional<UserCredential> = repository.findByName(username)
        return credential.map(Function<UserCredential, U> { userCredential: UserCredential? ->
            CustomUserDetails(userCredential)
        }).orElseThrow<UsernameNotFoundException>(
            Supplier<UsernameNotFoundException> { UsernameNotFoundException("user not found with name :$username") })
    }
}
