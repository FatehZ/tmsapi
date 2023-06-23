package com.ktxdevelopment.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Table
import org.springframework.data.annotation.Id
import javax.annotation.processing.Generated


@Entity
@Table
data class Student(
    @Id
    @GeneratedValue
    val id: Long,
    val name: String,
    val entryYear: Int,
    val gpa: Int = 0,
    val faculty: Faculty,
    val courses: List<Course> = listOf()
)