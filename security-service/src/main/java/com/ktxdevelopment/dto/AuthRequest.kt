package com.ktxdevelopment.dto

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Builder
data class AuthRequest (
    val username: String? = null,
    val password: String? = null
)
