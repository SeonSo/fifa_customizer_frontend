package com.example.onedaypiece.challenge.controller;

import com.example.onedaypiece.challenge.domain.challenge.Challenge;
import com.example.onedaypiece.challenge.service.ChallengeRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChallengeRecordController {

    private final ChallengeRecordService challengeRecordService;
    //전체보기
    @GetMapping("/api/challenge/list")
    @ResponseBody
    public List<Challenge> getChallenge(){
        return this.challengeRecordService.getChallenges();
    }
}
