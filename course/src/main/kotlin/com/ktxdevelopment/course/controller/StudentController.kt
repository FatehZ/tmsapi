package com.ktxdevelopment.controller


import com.ktxdevelopment.model.dto.StudentDto
import com.ktxdevelopment.model.entity.Student
import com.ktxdevelopment.model.request.StudentRequest
import com.ktxdevelopment.model.response.StudentResponse
import com.ktxdevelopment.service.StudentService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/students")
class StudentController (private val studentService: StudentService) {

    @PostMapping
    fun createStudent(@Valid @RequestBody studentRequest: StudentRequest): ResponseEntity<StudentResponse> {
        return ResponseEntity.ok(studentService.createStudent(studentRequest));
    }

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Long): ResponseEntity<String> {
        studentService.deleteStudent(id)
        return ResponseEntity.ok("Deleted successfully user $id")
    }

    @GetMapping
    fun getStudentsByPageAndLimit(@RequestParam("page") page: Int, @RequestParam("limit") limit: Int): List<StudentDto> {
        val students = studentService.getStudentsByPageAndLimit(page, limit)
        return students.map { mapToDto(it) }
    }

    @GetMapping("/name/{name}")
    fun getStudentsByName(@PathVariable name: String): List<StudentDto> {
        val students = studentService.getStudentsByName(name)
        return students.map { mapToDto(it) }
    }

    @GetMapping("/email/{email}")
    fun getStudentsByEmail(@PathVariable email: String): List<StudentDto> {
        val students = studentService.getStudentsByEmail(email)
        return students.map { mapToDto(it) }
    }

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long): StudentDto {
        val student = studentService.getStudentByStudentId(id)
        return mapToDto(student)
    }

    private fun mapToDto(student: Student): StudentDto {
        return StudentDto()//todo
    }
}