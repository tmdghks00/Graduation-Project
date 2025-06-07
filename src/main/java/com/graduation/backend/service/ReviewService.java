package com.graduation.backend.service;

import com.graduation.backend.entity.Review;

import java.util.List;

public interface ReviewService {
    Review createReview(Review review); // 리뷰 생성
    List<Review> getReviewsByUser(Long userId); // 특정 사용자에 대한 받은 리뷰 조회
}
