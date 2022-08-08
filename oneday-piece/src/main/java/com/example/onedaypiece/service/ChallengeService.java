package com.example.onedaypiece.service;

import com.example.onedaypiece.dao.ChallengeRepository;
import com.example.onedaypiece.domain.Challenge;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class ChallengeService {
    private final ChallengeRepository challengeRepository;

    public List<Challenge> getChallenges() {
        return challengeRepository.findAll();
    }

    public void postChallenge(String challengeTitle, String challengeCategory,
                              String challengeImg, String challengeHoliday,
                              LocalDate challengeStart, LocalDate challengeEnd,
                              String challengeAuthority) {
        Challenge challenge = new Challenge();
        challenge.setChallengeTitle(challengeTitle);
        challenge.setChallengeCategory(challengeCategory);
        challenge.setChallengeImg(challengeImg);
        challenge.setChallengeHoliday(challengeHoliday);
        challenge.setChallengeStart(challengeStart);
        challenge.setChallengeEnd(challengeEnd);
        challenge.setChallengeAuthority(challengeAuthority);
        this.challengeRepository.save(challenge);
    }
}
