package com.example.onedaypiece.service;

import com.example.onedaypiece.dao.ChallengeRepository;
import com.example.onedaypiece.domain.Challenge;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ChallengeService {
    private final ChallengeRepository challengeRepository;

    public List<Challenge> getChallenges() {
        return challengeRepository.findAll();
    }

    public void createChallenge(String category_name,String content) {
        Challenge challenge = new Challenge();
        challenge.setCatagoryName(category_name);
        challenge.setContent(content);
        this.challengeRepository.save(challenge);
    }
}
