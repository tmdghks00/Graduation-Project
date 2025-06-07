package com.graduation.backend.service;

import com.graduation.backend.entity.Alert;
import java.util.List;

/**
 * 알림 서비스 인터페이스
 * 사용자에게 알림을 생성하고, 알림 목록을 조회하는 기능을 정의함
 */
public interface AlertService {
    // 새로운 알림 생성
    Alert createAlert(Alert alert);

    // 특정 사용자 ID에 해당하는 알림 목록 조회
    List<Alert> getUserAlerts(Long userId);
}
