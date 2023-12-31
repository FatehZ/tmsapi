package com.ktxdevelopment.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
class UserCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id = 0
    private val name: String? = null
    private val email: String? = null
    private val password: String? = null
}
