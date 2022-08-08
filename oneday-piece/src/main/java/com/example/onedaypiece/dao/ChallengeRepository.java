package com.example.onedaypiece.dao;


import com.example.onedaypiece.domain.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository<Challenge, Integer> {
}
