package com.ktxdevelopment.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class Transcript {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String transcriptId;

    @OneToOne
    private Student student;

}
