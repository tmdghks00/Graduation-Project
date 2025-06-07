package com.graduation.backend.dto;

import lombok.*;

// 게시글 생성 및 수정을 위한 DTO
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    // 게시글 제목
    private String title;

    // 게시글 본문 내용
    private String content;
}
