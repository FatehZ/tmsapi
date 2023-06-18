package com.ktxdevelopment.service;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentServiceImpl(private val studentRepository: StudentRepository) : StudentService {

    override fun createStudent(studentRequest: StudentRequest): Student {
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
