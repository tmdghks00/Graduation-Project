package com.graduation.backend.controller;

import com.graduation.backend.entity.Alert;
import com.graduation.backend.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alert")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService alertService;

    @PostMapping
    // ➕ 알림 생성
    public Alert createAlert(@RequestBody Alert alert) {
        return alertService.createAlert(alert);
    }

    @GetMapping("/user/{userId}")
    // 🔍 특정 유저의 알림 목록 조회
    public List<Alert> getUserAlerts(@PathVariable Long userId) {
        return alertService.getUserAlerts(userId);
    }
}
