package com.ktxdevelopment.model.entity


data class Course(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val credits: Int = 0,
    val grades: List<Grade> = listOf()
)