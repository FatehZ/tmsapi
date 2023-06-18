package com.ktxdevelopment.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/students")
class StudentController(private val studentService: StudentService) {

    @PostMapping
    fun createStudent(@Valid @RequestBody studentRequest: StudentRequest): StudentDto {
        val createdStudent = studentService.createStudent(studentRequest)
        return mapToDto(createdStudent)
    }

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Long) {
        studentService.deleteStudent(id)
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
        val student = studentService.getStudentById(id)
        return mapToDto(student)
    }

    private fun mapToDto(student: Student): StudentDto {
        return StudentDto(student.id, student.name, student.email)
    }
}