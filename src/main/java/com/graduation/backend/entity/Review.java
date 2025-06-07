package com.graduation.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * 사용자 리뷰 정보를 저장하는 엔티티
 */
@Entity
@Table(name = "review")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 리뷰 작성자 ID
    private Long reviewerId;

    // 리뷰 대상자 ID
    private Long revieweeId;

    // 별점 (1~5)
    private int rating;

    // 리뷰 내용
    private String content;

    // 작성 시각
    private LocalDateTime createdAt;
}
