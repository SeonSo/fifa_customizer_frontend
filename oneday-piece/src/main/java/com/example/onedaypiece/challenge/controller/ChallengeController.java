package com.example.onedaypiece.challenge.controller;

import com.example.onedaypiece.domain.Challenge;
import com.example.onedaypiece.service.ChallengeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/challenge")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChallengeController {
    private final ChallengeService challengeService;

    @GetMapping("")
    @ResponseBody
    public List<Challenge> getChallenges(){
        return this.challengeService.getChallenges();
    }

    @PostMapping("/create")
    @ResponseBody
    public String postChallenge(@RequestBody Challenge challenge){
        System.out.println("challenge");
        System.out.println(challenge);
        this.challengeService.postChallenge(challenge.getChallengeTitle(), challenge.getChallengeCategory(),
                challenge.getChallengeContent(), challenge.getChallengeHoliday(), challenge.getChallengeStart(), challenge.getChallengeEnd(),
                challenge.getChallengeAuthority());
        return "생성됨";
    }
}
