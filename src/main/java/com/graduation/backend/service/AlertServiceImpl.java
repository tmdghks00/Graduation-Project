package com.graduation.backend.service;

import com.graduation.backend.entity.Alert;
import com.graduation.backend.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 알림 서비스 구현체
 */
@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {

    // 알림 저장소 의존성 주입
    private final AlertRepository alertRepository;

    // 알림 생성 시 현재 시간 설정 및 읽지 않음 상태로 저장
    @Override
    public Alert createAlert(Alert alert) {
        alert.setCreatedAt(LocalDateTime.now());
        alert.setRead(false);
        return alertRepository.save(alert);
    }

    // 특정 사용자에 대한 알림 리스트 조회
    @Override
    public List<Alert> getUserAlerts(Long userId) {
        return alertRepository.findByUserId(userId);
    }
}
