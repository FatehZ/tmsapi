package com.ktxdevelopment.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class StudentApplication

fun main(args: Array<String>) {
    SpringApplication.run(StudentApplication::class.java, *args)
}