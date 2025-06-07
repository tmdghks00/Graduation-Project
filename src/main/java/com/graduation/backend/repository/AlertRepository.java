package com.graduation.backend.repository;

import com.graduation.backend.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Alert 엔티티를 위한 JPA 레포지토리
 */
public interface AlertRepository extends JpaRepository<Alert, Long> {

    // 사용자 ID로 알림 전체 조회
    List<Alert> findByUserId(Long userId);
}
