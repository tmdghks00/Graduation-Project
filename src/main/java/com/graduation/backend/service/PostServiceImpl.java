package com.graduation.backend.service;

import com.graduation.backend.dto.PostDto;
import com.graduation.backend.entity.Post;
import com.graduation.backend.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(PostDto dto, String userEmail) {
        Post post = Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .authorEmail(userEmail)
                .build();
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글 없음"));
    }

    @Override
    public Post updatePost(Long id, PostDto dto, String userEmail) {
        Post post = getPost(id);
        if (!post.getAuthorEmail().equals(userEmail)) {
            throw new RuntimeException("작성자만 수정할 수 있습니다.");
        }
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id, String userEmail) {
        Post post = getPost(id);
        if (!post.getAuthorEmail().equals(userEmail)) {
            throw new RuntimeException("작성자만 삭제할 수 있습니다.");
        }
        postRepository.delete(post);
    }
}
