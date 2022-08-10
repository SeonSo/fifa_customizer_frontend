package com.example.onedaypiece.challenge.domain.challenge;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@NoArgsConstructor
@Entity
@Data
public class Challenge implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer challengeId;

    @Column(length = 100)
    private String challengeTitle;

    @Column(name = "challenge_category", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ChallengeCategory challengeCategory;

    @Column
    private String challengeImg;

    @Column(length = 200)
    private String challengeHoliday;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate challengeStart;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate challengeEnd;

    private Integer viewCount;

    @Column
    private String challengeAuthority;

    @Column
    private String challengeAuthorityMethod;

    @Column(columnDefinition="TEXT")
    private String challengeContent;

    @Column
    private String password;

    @Column
    private String weekTag;

    @Builder
    public Challenge(String challengeTitle, ChallengeCategory challengeCategory,
                    String challengeImg, String challengeHoliday,
                    LocalDate challengeStart, LocalDate challengeEnd,
                    Integer viewCount, String challengeAuthority, String challengeAuthorityMethod,
                    String challengeContent, String password) {
        this.challengeTitle = challengeTitle;
        this.challengeCategory = challengeCategory;
        this.challengeImg = challengeImg;
        this.challengeHoliday = challengeHoliday;
        this.challengeStart = challengeStart;
        this.challengeEnd = challengeEnd;
        this.viewCount = viewCount;
        this.challengeAuthority = challengeAuthority;
        this.challengeAuthorityMethod = challengeAuthorityMethod;
        this.challengeContent = challengeContent;
        this.password = password;

        if (ChronoUnit.DAYS.between(challengeStart, challengeEnd) <= 7) {
            this.weekTag = "1주";
        } else if (ChronoUnit.DAYS.between(challengeStart, challengeEnd) <= 14) {
            this.weekTag = "2주";
        } else if (ChronoUnit.DAYS.between(challengeStart, challengeEnd) <= 21) {
            this.weekTag = "3주";
        } else {
            this.weekTag = "4주";
        }
    }

    public static Challenge createChallenge() {
        return Challenge.builder()
                .challengeTitle(createChallenge().getChallengeTitle())
                .challengeCategory(createChallenge().getChallengeCategory())
                .challengeImg(createChallenge().getChallengeImg())
                .challengeHoliday(createChallenge().getChallengeHoliday())
                .challengeStart(createChallenge().getChallengeStart())
                .challengeEnd(createChallenge().getChallengeEnd())
                .viewCount(createChallenge().getViewCount())
                .challengeAuthority(createChallenge().getChallengeAuthority())
                .challengeAuthorityMethod(createChallenge().getChallengeAuthorityMethod())
                .challengeContent(createChallenge().getChallengeContent())
                .password(createChallenge().getPassword())
                .build();
    }
}
