package com.graduation.backend.service;

import com.graduation.backend.dto.DogProfileDto;
import com.graduation.backend.entity.DogProfile;
import com.graduation.backend.repository.DogProfileRepository;
import org.springframework.stereotype.Service;

/**
 * 강아지 프로필 서비스 구현체
 */
@Service
public class DogProfileServiceImpl implements DogProfileService {

    private final DogProfileRepository repository;

    public DogProfileServiceImpl(DogProfileRepository repository) {
        this.repository = repository;
    }

    // DTO를 엔티티로 변환하여 저장소에 저장
    @Override
    public void createProfile(DogProfileDto dto) {
        DogProfile profile = new DogProfile(dto);
        repository.save(profile);
    }
}
