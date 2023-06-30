package com.ktxdevelopment.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import org.springframework.context.annotation.Lazy

@Entity
@Table(name = "faculty")
data class Faculty(
    @Id
    @GeneratedValue
    val id: Int,
    val name: String,
    @Lazy @OneToMany val courses: List<Course>
)