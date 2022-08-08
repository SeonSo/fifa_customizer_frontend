package com.example.onedaypiece.service;

import com.example.onedaypiece.dao.ChallengeRepository;
import com.example.onedaypiece.domain.Challenge;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class ChallengeService {
    private final ChallengeRepository challengeRepository;

    public List<Challenge> getChallenges() {
        return challengeRepository.findAll();
    }

    @Transactional
    public void postChallenge() {

        Challenge challenge = new Challenge();
        this.challengeRepository.save(challenge);
    }
}
