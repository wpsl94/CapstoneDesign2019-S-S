package com.capstonedesign.backend.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Cup {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String cupName;

    @Column(nullable = false)
    private Integer cupWeight;
}
