package com.ktxdevelopment.model.entity;

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

    @OneToOne
    private Transcript transcript;

    @OneToMany(mappedBy = "courseId")
    private Course course;

    private Double score;
}