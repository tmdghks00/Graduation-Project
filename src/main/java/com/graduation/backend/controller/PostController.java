package com.graduation.backend.controller;

import com.graduation.backend.dto.PostDto;
import com.graduation.backend.entity.Post;
import com.graduation.backend.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    // 게시글 생성 (로그인된 유저 이메일 추출)
    public ResponseEntity<Post> createPost(@RequestBody PostDto dto, HttpServletRequest request) {
        String userEmail = (String) request.getAttribute("email");
        Post post = postService.createPost(dto, userEmail);
        return ResponseEntity.ok(post);
    }

    @GetMapping
    // 전체 게시글 목록 조회
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PutMapping("/{id}")
    // 게시글 수정
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody PostDto dto, HttpServletRequest request) {
        String userEmail = (String) request.getAttribute("email");
        Post updatedPost = postService.updatePost(id, dto, userEmail);
        return ResponseEntity.ok(updatedPost);
    }

    @DeleteMapping("/{id}")
    // 게시글 삭제
    public ResponseEntity<Void> deletePost(@PathVariable Long id, HttpServletRequest request) {
        String userEmail = (String) request.getAttribute("email");
        postService.deletePost(id, userEmail);
        return ResponseEntity.ok().build();
    }
}
