package com.ktxdevelopment.dto

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor


@Data
@AllArgsConstructor
@NoArgsConstructor
class AuthRequest {
    private val username: String? = null
    private val password: String? = null
}
