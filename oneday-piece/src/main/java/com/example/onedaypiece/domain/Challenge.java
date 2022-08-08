package com.example.onedaypiece.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer challengeId;

    @Column(length = 100)
    private String challengeTitle;

    @Column
    private String challengeCategory;

    @Column
    private String challengeImg;

    @Column(length=200)
    private String challengeHoliday;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate challengeStart;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate challengeEnd;

    @Column
    private String challengeAuthority;

    @Column(columnDefinition="TEXT")
    private String challengeContent;

}
