package com.ktxdevelopment.model.entity

import jakarta.persistence.*


@Entity
@Table
data class Student(
    @Column(unique = false,name = "first_name")
    val firstName: String,

    @Column(unique = false, name = "Last_name")
    val lastName: String,

    @Column(unique = false, name = "Last_name")
    val profileImage: String,

    val entryYear: Int,

    val gpa: Int = 0,

    @ManyToOne
    val faculty: Faculty,

    @ManyToMany
    val courses: List<Course> = listOf()
) {
    @Id
    @GeneratedValue
    public var id: Long = 0
}