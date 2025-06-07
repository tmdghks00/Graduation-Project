package com.graduation.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * 실시간 채팅 메시지 정보를 저장하는 엔티티
 */
@Entity
@Table(name = "chat_message")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 보낸 사람 ID
    private Long senderId;

    // 받는 사람 ID
    private Long receiverId;

    // 메시지 내용
    private String message;

    // 전송 시각
    private LocalDateTime sentAt;

    // 매칭 ID (선택적으로 연결)
    private Long matchId;
}
