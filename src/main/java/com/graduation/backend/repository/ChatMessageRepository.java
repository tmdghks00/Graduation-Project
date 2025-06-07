package com.graduation.backend.repository;

import com.graduation.backend.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ChatMessage 엔티티를 위한 JPA 레포지토리
 */
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}
