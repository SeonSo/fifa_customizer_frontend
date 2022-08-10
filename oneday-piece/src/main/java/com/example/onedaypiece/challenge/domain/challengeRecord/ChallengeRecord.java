package com.example.onedaypiece.challenge.domain.challengeRecord;

import com.example.onedaypiece.challenge.domain.challenge.Challenge;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
public class ChallengeRecord {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long challengeRecordId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;

    @Column(name = "challenge_record_status", nullable = false)
    private boolean challengeRecordStatus;

    @Builder
    public ChallengeRecord(Challenge challenge) {
        this.challenge = challenge;
        this.challengeRecordStatus = true;
    }
    public static ChallengeRecord createChallengeRecord(Challenge challenge){
        return ChallengeRecord.builder()
                .challenge(challenge)
                .build();
    }

    public void setStatusFalse() {
        this.challengeRecordStatus = false;
    }
}
