package com.example.onedaypiece.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private LocalDateTime challengeStart;

    @Column
    private LocalDateTime challengeEnd;

    @Column
    private String challengeAuthority;

    @Column(columnDefinition="TEXT")
    private String challengeContent;

}
