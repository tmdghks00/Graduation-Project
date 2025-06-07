// PostService.java
package com.graduation.backend.service;

import com.graduation.backend.dto.PostDto;
import com.graduation.backend.entity.Post;

import java.util.List;

public interface PostService {
    Post createPost(PostDto dto, String userEmail); // 게시글 생성
    List<Post> getAllPosts(); // 모든 게시글 조회
    Post getPost(Long id); // 단일 게시글 조회
    Post updatePost(Long id, PostDto dto, String userEmail); // 게시글 수정
    void deletePost(Long id, String userEmail); // 게시글 삭제
}
