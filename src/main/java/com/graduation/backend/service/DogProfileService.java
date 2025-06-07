package com.graduation.backend.service;

import com.graduation.backend.dto.DogProfileDto;

/**
 * 강아지 프로필 서비스 인터페이스
 */
public interface DogProfileService {
    DogProfileDto createDogProfile(DogProfileDto dto);
    DogProfileDto getDogProfile(Long id);
    DogProfileDto updateDogProfile(Long id, DogProfileDto dto);
    void deleteDogProfile(Long id);
}
