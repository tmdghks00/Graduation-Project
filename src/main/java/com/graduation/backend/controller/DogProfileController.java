package com.graduation.backend.controller;

import com.graduation.backend.dto.DogProfileDto;
import com.graduation.backend.service.DogProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dogs")
public class DogProfileController {

    private final DogProfileService dogProfileService;

    // 🐶 1. 강아지 등록
    @PostMapping
    public ResponseEntity<DogProfileDto> createDogProfile(@RequestBody DogProfileDto dto) {
        DogProfileDto created = dogProfileService.createDogProfile(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // 🔍 2. 강아지 조회
    @GetMapping("/{id}")
    public ResponseEntity<DogProfileDto> getDogProfile(@PathVariable Long id) {
        DogProfileDto dogProfile = dogProfileService.getDogProfile(id);
        return ResponseEntity.ok(dogProfile);
    }

    // ✏️ 3. 강아지 수정
    @PutMapping("/{id}")
    public ResponseEntity<DogProfileDto> updateDogProfile(@PathVariable Long id,
                                                          @RequestBody DogProfileDto dto) {
        DogProfileDto updated = dogProfileService.updateDogProfile(id, dto);
        return ResponseEntity.ok(updated);
    }

    // 🗑️ 4. 강아지 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDogProfile(@PathVariable Long id) {
        dogProfileService.deleteDogProfile(id);
        return ResponseEntity.noContent().build();
    }
}
