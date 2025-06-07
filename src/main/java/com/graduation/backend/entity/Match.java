package com.graduation.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * 두 강아지 간의 매칭 정보를 저장하는 엔티티
 */
@Entity
@Table(name = "matches") // 복수형으로 변경
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 매칭된 강아지 ID들
    private Long dog1Id;
    private Long dog2Id;

    // 매칭 여부 (true: 매칭 완료)
    private boolean matched;

    // 매칭 상태 예: "PENDING", "ACCEPTED"
    private String matchStatus;

    // 매칭된 시점
    private LocalDateTime matchedAt;
}
