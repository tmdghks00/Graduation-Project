package com.graduation.backend.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 커뮤니티 게시글 정보를 저장하는 엔티티
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    // 게시글 고유 ID (자동 증가)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 게시글 제목
    private String title;

    // 게시글 내용
    private String content;

    // 작성자 이메일 (User와 직접 연결하지 않고 문자열로 저장)
    private String authorEmail;
}
