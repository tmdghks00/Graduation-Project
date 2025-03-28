// PostRepository.java
package com.graduation.backend.repository;

import com.graduation.backend.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
