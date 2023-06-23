package com.ktxdevelopment.service

import com.ktxdevelopment.model.entity.Student
import com.ktxdevelopment.model.request.StudentRequest

interface StudentService {
    fun createStudent(studentRequest: StudentRequest): Student
    fun deleteStudent(id: Long)
    fun getStudentsByPageAndLimit(page: Int, limit: Int): List<Student>
    fun getStudentsByName(name: String): List<Student>
    fun getStudentsByEmail(email: String): List<Student>
    fun getStudentById(id: Long): Student
}