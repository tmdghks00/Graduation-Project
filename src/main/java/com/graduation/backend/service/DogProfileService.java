package com.graduation.backend.service;

import com.graduation.backend.dto.DogProfileDto;

/**
 * 강아지 프로필 서비스 인터페이스
 */
public interface DogProfileService {

    // 강아지 프로필 생성
    void createProfile(DogProfileDto dto);
}
