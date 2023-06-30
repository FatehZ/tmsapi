package com.ktxdevelopment.service;

import com.ktxdevelopment.repo.StudentRepository
import com.ktxdevelopment.model.entity.Student
import com.ktxdevelopment.model.request.StudentRequest
import com.ktxdevelopment.model.response.StudentResponse
import org.springframework.stereotype.Service

@Service
class StudentServiceImpl(private val studentRepository: StudentRepository) : StudentService {

    override fun createStudent(studentRequest: StudentRequest): StudentResponse {
        val student = Student(studentRequest.name, studentRequest.email)
        return studentRepository.save(student)
    }

    override fun deleteStudent(id: Long) {
        studentRepository.deleteById(id)
    }

    override fun getStudentsByPageAndLimit(page: Int, limit: Int): List<Student> {
        return studentRepository.findAll()
    }

    override fun getStudentsByName(name: String): List<Student> {
        return studentRepository.findByName(name)
    }
}
