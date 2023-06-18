package com.javatechie.config;

import com.javatechie.entity.UserCredential
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails(userCredential: UserCredential) : UserDetails {
    private val username: String
    private val password: String

    init {
        username = userCredential.getName()
        password = userCredential.getPassword()
    }

    override fun getAuthorities(): kotlin.collections.Collection<GrantedAuthority?> {
        return null
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}

