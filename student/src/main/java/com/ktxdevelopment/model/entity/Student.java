package com.ktxdevelopment.model.entity

import jakarta.persistence.*
import org.springframework.context.annotation.Lazy;


@Table(name = "students")
@Entity(name = "student")
class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true, name = "student_id")
    private String studentId;

    @Column(unique = false, name = "first_name")
    private String firstName;

    @Column(unique = false, name = "last_name")
    private String lastName;

    @Column(unique = false, name = "profile_image")
    private String profileImage;


    private Course course;

    @OneToOne
    @Lazy
    private Transcript transcript;

    @OneToOne
    private PaymentProfile paymentProfile;
}