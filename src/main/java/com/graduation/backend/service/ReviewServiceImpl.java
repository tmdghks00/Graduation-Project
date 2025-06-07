package com.graduation.backend.service;

import com.graduation.backend.entity.Review;
import com.graduation.backend.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    // 리뷰 생성 시 현재 시간 저장 후 저장소에 저장
    @Override
    public Review createReview(Review review) {
        review.setCreatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    // 특정 사용자 ID를 기준으로 받은 리뷰 목록 조회
    @Override
    public List<Review> getReviewsByUser(Long userId) {
        return reviewRepository.findByRevieweeId(userId);
    }
}
