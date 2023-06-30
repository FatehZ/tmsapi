package com.ktxdevelopment.repo

import com.ktxdevelopment.model.entity.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface StudentRepository : JpaRepository<Student, Int>, PagingAndSortingRepository<Student, Int> {

}