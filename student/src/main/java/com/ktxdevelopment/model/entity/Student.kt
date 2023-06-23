package com.ktxdevelopment.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Table
import org.springframework.data.annotation.Id


@Entity
@Table
data class Student(
    @Id
    @GeneratedValue
    val id: Long,

    @Column(unique = false,name = "first_name")
    val firstName: String,
    @Column(unique = false, name = "Last_name")
    val lastName: String,
    @Column(unique = false, name = "Last_name")
    val profileImage: String,
    val entryYear: Int,
    val gpa: Int = 0,
    val faculty: Faculty,
    val courses: List<Course> = listOf()
)