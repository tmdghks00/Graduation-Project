package com.graduation.backend.repository;

import com.graduation.backend.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Match 엔티티를 위한 JPA 레포지토리
 */
public interface MatchRepository extends JpaRepository<Match, Long> {
}
