package com.graduation.backend.service;

import com.graduation.backend.dto.DogProfileDto;
import com.graduation.backend.entity.DogProfile;
import com.graduation.backend.entity.User;
import com.graduation.backend.repository.DogProfileRepository;
import com.graduation.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 강아지 프로필 서비스 구현체
 */
@Service
@RequiredArgsConstructor
public class DogProfileServiceImpl implements DogProfileService {

    private final DogProfileRepository dogProfileRepository;
    private final UserRepository userRepository;

    // 등록
    @Override
    public DogProfileDto createDogProfile(DogProfileDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        DogProfile dog = DogProfile.builder()
                .name(dto.getName())
                .breed(dto.getBreed())
                .age(dto.getAge())
                .gender(dto.getGender())
                .imageUrl(dto.getImageUrl())
                .user(user)
                .build();

        return DogProfileDto.from(dogProfileRepository.save(dog));
    }

    // 조회
    @Override
    public DogProfileDto getDogProfile(Long id) {
        DogProfile dog = dogProfileRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 강아지 정보를 찾을 수 없습니다."));
        return DogProfileDto.from(dog);
    }

    // 수정
    @Override
    public DogProfileDto updateDogProfile(Long id, DogProfileDto dto) {
        DogProfile dog = dogProfileRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("수정할 강아지 정보가 없습니다."));

        dog.setName(dto.getName());
        dog.setBreed(dto.getBreed());
        dog.setAge(dto.getAge());
        dog.setGender(dto.getGender());
        dog.setImageUrl(dto.getImageUrl());

        return DogProfileDto.from(dogProfileRepository.save(dog));
    }

    // 삭제
    @Override
    public void deleteDogProfile(Long id) {
        if (!dogProfileRepository.existsById(id)) {
            throw new IllegalArgumentException("해당 ID의 강아지 프로필이 없습니다.");
        }
        dogProfileRepository.deleteById(id);
    }
}
