package com.graduation.backend.controller;

import com.graduation.backend.entity.Review;
import com.graduation.backend.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    // 리뷰 생성 (POST /api/review)
    // 요청 바디에 담긴 Review 객체를 사용하여 새로운 리뷰 저장
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    @GetMapping("/user/{userId}")
    // 특정 유저가 받은 모든 리뷰 조회 (GET /api/review/user/{userId})
    public List<Review> getUserReviews(@PathVariable Long userId) {
        return reviewService.getReviewsByUser(userId);
    }
}
