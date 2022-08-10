package com.example.onedaypiece.challenge.service;

import com.example.onedaypiece.challenge.dao.ChallengeRecordRepository;
import com.example.onedaypiece.challenge.dao.ChallengeRepository;
import com.example.onedaypiece.challenge.domain.challenge.Challenge;
import com.example.onedaypiece.challenge.domain.challenge.ChallengeQueryRepository;
import com.example.onedaypiece.exception.DataNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.example.onedaypiece.challenge.domain.challenge.Challenge.createChallenge;

@AllArgsConstructor
@Service
public class ChallengeService {
    private final ChallengeRepository challengeRepository;
    private final ChallengeQueryRepository challengeQueryRepository;
    private final ChallengeRecordRepository challengeRecordRepository;


    // 챌린지 단건조회(조회수 포함)
    public Challenge getChallenge(Integer challengeId) {
        Optional<Challenge> ViewChallenge = this.challengeRepository.findById(challengeId);
        if (ViewChallenge.isPresent()) {
            Challenge challenge = ViewChallenge.get();
            challenge.setViewCount(challenge.getViewCount() + 1);
            this.challengeRepository.save(challenge);
            return challenge;
        } else {
            throw new DataNotFoundException("challenge not found");
        }
    }

    // 챌린지 생성
//    @Transactional
//    public Integer postChallenge() {
//        Challenge challenge = createChallenge();
//        challengeRepository.save(challenge);
//
//        Integer challengeId = challenge.getChallengeId();
//        ChallengeRecord challengeRecord = createChallengeRecord(challenge);
//        challengeRecordRepository.save(challengeRecord);
//
//        return challengeId;
//    }

    @Transactional
    public Integer postChallenge() {
        Challenge challenge = createChallenge();
        challengeRepository.save(challenge);

        Integer challengeId = challenge.getChallengeId();
        return challengeId;
    }


}
