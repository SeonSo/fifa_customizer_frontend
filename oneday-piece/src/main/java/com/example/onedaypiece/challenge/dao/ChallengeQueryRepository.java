package com.example.onedaypiece.challenge.domain.challenge;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ChallengeQueryRepository {

    private final JPAQueryFactory queryFactory;

//    public Slice<Challenge> findAllByWord(String words, Pageable pageable){
//        List<Challenge> challengeList = queryFactory
//                .selectFrom(challenge)
//                .distinct()
//                .join(challengeRecord).on(challenge.challengeId.eq(challengeRecord.challenge.challengeId))
//                .where(challenge.challengeCategory.ne(ChallengeCategory.OFFICIAL),
//                        challenge.challengeTitle.contains(words))
//                .orderBy(challenge.challengeStart.asc())
//                .offset(pageable.getOffset()).limit(pageable.getPageSize()+1).fetch();
//        return RepositoryHelper.toSlice(challengeList, pageable);
//    }

//    public List<Challenge> findAllByOfficialChallenge() {
//        return queryFactory
//                .selectFrom(challenge)
//                .where(challenge.challengeCategory.eq(ChallengeCategory.OFFICIAL))
//                .fetch();
//    }

//    private String getPeriodString(String period) {
//        return period + "주";
//    }

//    public Optional<Challenge> findById(Integer challengeId) {
//        return Optional.ofNullable(queryFactory
//                .selectFrom(challenge)
//                .where(challenge.challengeId.eq(challengeId))
//                .fetchOne());
//    }
}
