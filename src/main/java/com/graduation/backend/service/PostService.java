// PostService.java
package com.graduation.backend.service;

import com.graduation.backend.dto.PostDto;
import com.graduation.backend.entity.Post;

import java.util.List;

public interface PostService {
    Post createPost(PostDto dto, String userEmail);
    List<Post> getAllPosts();
    Post getPost(Long id);
    Post updatePost(Long id, PostDto dto, String userEmail);
    void deletePost(Long id, String userEmail);
}
