package com.ktxdevelopment.controller


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
    fun getStudentsByPageAndLimit(
        @RequestParam("page") page: Int,
        @RequestParam("limit") limit: Int
    ): ResponseEntity<List<StudentResponse>> {
        return ResponseEntity.ok(studentService.getStudentsByPageAndLimit(page, limit))
    }

    @GetMapping("/name/{name}")
    fun getStudentsByName(@PathVariable name: String): ResponseEntity<List<StudentResponse>> {
        return ResponseEntity.ok(studentService.searchStudentsByName(name))
    }

    @GetMapping("/email/{email}")
    fun getStudentsByEmail(@PathVariable email: String): ResponseEntity<List<StudentResponse>> {
        return ResponseEntity.ok(studentService.getStudentsByEmail(email))
    }

    @GetMapping("/{studentId}")
    fun getStudentByStudentId(@PathVariable studentId: Long): ResponseEntity<StudentResponse> {
        return ResponseEntity.ok(studentService.getStudentByStudentId(studentId))
    }
}