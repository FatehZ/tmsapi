package com.ktxdevelopment.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class Course {

    @Id
    @GeneratedValue
    private Integer id;

    private String courseId;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
}