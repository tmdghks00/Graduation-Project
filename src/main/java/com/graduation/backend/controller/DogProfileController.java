package com.graduation.backend.controller;

import com.graduation.backend.dto.DogProfileDto;
import com.graduation.backend.service.DogProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dogs")
public class DogProfileController {

    private final DogProfileService dogProfileService;

    // 생성자 주입을 통해 DogProfileService 사용
    public DogProfileController(DogProfileService dogProfileService) {
        this.dogProfileService = dogProfileService;
    }

    @PostMapping
    // 강아지 프로필 생성 (POST /api/dogs)
    // 요청 바디에 담긴 DogProfileDto 객체를 통해 프로필 생성
    public void createDogProfile(@RequestBody DogProfileDto dto) {
        dogProfileService.createProfile(dto);
    }
}
