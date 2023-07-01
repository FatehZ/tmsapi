package com.ktxdevelopment.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import org.springframework.context.annotation.Lazy

import java.util.List;

@Entity(name = "faculty")
@Table(name = "faculties")
class Faculty {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Lazy
    @OneToMany
    List<Course> courses;
}