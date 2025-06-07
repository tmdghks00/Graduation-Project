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

    // 게시글 생성: 사용자 이메일 기반으로 작성자 설정
    @Override
    public Post createPost(PostDto dto, String userEmail) {
        Post post = Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .authorEmail(userEmail)
                .build();
        return postRepository.save(post);
    }

    // 모든 게시글 반환
    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // 특정 게시글 ID로 조회 (없으면 예외 발생)
    @Override
    public Post getPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글 없음"));
    }

    // 게시글 수정 (작성자 본인만 가능)
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

    // 게시글 삭제 (작성자 본인만 가능)
    @Override
    public void deletePost(Long id, String userEmail) {
        Post post = getPost(id);
        if (!post.getAuthorEmail().equals(userEmail)) {
            throw new RuntimeException("작성자만 삭제할 수 있습니다.");
        }
        postRepository.delete(post);
    }
}
