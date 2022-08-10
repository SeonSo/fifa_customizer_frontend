package com.example.onedaypiece.challenge.domain.challengeRecord;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ChallengeRecordQueryRepository {

    private final JPAQueryFactory queryFactory;


//    public List<ChallengeRecord> findAllByChallenge(List<Challenge> challengeList){
//        return queryFactory.select(challengeRecord)
//                .from(challengeRecord)
//                .join(challengeRecord.challenge,challenge)
//                .where(challengeRecord.challenge.in(challengeList))
//                .fetch();
//    }

//    public List<ChallengeRecord> findAllByChallengeList(Slice<Challenge> challengeList){
//        return queryFactory.select(challengeRecord)
//                .from(challengeRecord).fetchJoin()
//                .distinct()
//                .where(challengeRecord.challenge.in(challengeList.getContent()))
//                .fetch();
//    }

}
