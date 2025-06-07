package com.graduation.backend.repository;

import com.graduation.backend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Review 엔티티를 위한 JPA 레포지토리
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // 피리뷰이(리뷰 받는 유저) ID로 리뷰 목록 조회
    List<Review> findByRevieweeId(Long revieweeId);
}
