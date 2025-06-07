package com.graduation.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * 사용자에게 알림 정보를 전달하는 엔티티
 */
@Entity
@Table(name = "alert")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 알림 대상 사용자 ID
    private Long userId;

    // 알림 종류 예: "LIKE", "MATCH", "REVIEW"
    private String type;

    // 알림 내용
    private String message;

    // 읽음 여부
    private boolean isRead;

    // 알림 생성 시각
    private LocalDateTime createdAt;
}
