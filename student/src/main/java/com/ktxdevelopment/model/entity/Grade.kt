package com.ktxdevelopment.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor


//@Entity
@Table
data class Grade(
    @Id
    @GeneratedValue
    val id: Int,
    val studentId: Int,
    val courseId: Int,
    val grade: Double
)
