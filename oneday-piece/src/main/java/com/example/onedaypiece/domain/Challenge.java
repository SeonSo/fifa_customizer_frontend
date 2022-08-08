package com.example.onedaypiece.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column(columnDefinition="TEXT")
    private String content;

    @Column
    private String catagoryName;

    @Column
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;

    @Column
    private String imgUrl;

    @Column(length=200)
    private String challengeHoliday;

}
