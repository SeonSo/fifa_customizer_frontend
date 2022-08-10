package com.example.onedaypiece.challenge.controller;

import com.example.onedaypiece.challenge.domain.challenge.Challenge;
import com.example.onedaypiece.challenge.service.ChallengeService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/challenge")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChallengeController {
    private final ChallengeService challengeService;

    @GetMapping("/detail/{challengeId}")
    public String getChallengeDetail(Model model, @PathVariable Integer challengeId) {
        Challenge challenge = this.challengeService.getChallenge(challengeId);
        model.addAttribute("challenge", challenge);
        // 조회수 기능 구현
        return "challenge";
    }

    @PostMapping("/create")
    @ResponseBody
    public String postChallenge(@RequestBody Challenge challenge){
        System.out.println(challenge);
        this.challengeService.postChallenge();
        return "생성됨";
    }
}
