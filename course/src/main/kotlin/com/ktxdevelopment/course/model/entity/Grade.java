package com.ktxdevelopment.course.model.entity;

import com.ktxdevelopment.model.entity.Course;
import com.ktxdevelopment.model.entity.Student;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Entity(name = "grade")
@Table(name = "grades")
class Grade {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    private Student student;

    @OneToMany(mappedBy = "courseId")
    private Course course;

    private Double score;
}