package com.ktxdevelopment.service

import com.ktxdevelopment.model.request.StudentRequest
import com.ktxdevelopment.model.response.StudentResponse

interface StudentService {
    fun createStudent(studentRequest: StudentRequest): StudentResponse
    fun deleteStudent(id: Long)
    fun getStudentsByPageAndLimit(page: Int, limit: Int): List<StudentResponse>
    fun getStudentsByEmail(email: String): List<StudentResponse>
    fun getStudentByStudentId(id: Long): StudentResponse
}