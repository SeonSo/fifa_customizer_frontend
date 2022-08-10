package com.example.onedaypiece.challenge.service;

import com.example.onedaypiece.challenge.dao.ChallengeRecordRepository;
import com.example.onedaypiece.challenge.dao.ChallengeRepository;
import com.example.onedaypiece.challenge.domain.challenge.Challenge;
import com.example.onedaypiece.challenge.domain.challenge.ChallengeQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChallengeRecordService {

    private final ChallengeRepository challengeRepository;
    private final ChallengeQueryRepository challengeQueryRepository;
    private final ChallengeRecordRepository challengeRecordRepository;

    // 챌린지 전체 조회
    public List<Challenge> getChallenges() {
        return challengeRepository.findAll();
    }

    // 챌린지 카테고리별 조회
//    public ChallengeRecord getChallengeBySearch(String word, String categoryName,
//                                                         int period, int progress, int page) {
//        Pageable pageable = PageRequest.of(page - 1, SEARCH_SIZE);
//        Slice<Challenge> challengeList = challengeQueryRepository
//                .findAllBySearch(word, categoryName, period, progress, pageable);
//
//        Map<Challenge, List<ChallengeRecord>> recordMap = challengeRecordQueryRepository
//                .findAllByChallengeList(challengeList).stream()
//                .collect(Collectors.groupingBy(ChallengeRecord::getChallenge));
//
//        return getChallengeListResponseDto(challengeList, recordMap);
//    }
}
