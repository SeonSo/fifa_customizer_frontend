package com.example.onedaypiece.challenge.dao;

import com.example.onedaypiece.challenge.domain.challengeRecord.ChallengeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRecordRepository extends JpaRepository<ChallengeRecord, Long> {

}
