package com.graduation.backend.controller;

import com.graduation.backend.dto.DogProfileDto;
import com.graduation.backend.service.DogProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dogs")
public class DogProfileController {

    private final DogProfileService dogProfileService;

    public DogProfileController(DogProfileService dogProfileService) {
        this.dogProfileService = dogProfileService;
    }

    @PostMapping
    public void createDogProfile(@RequestBody DogProfileDto dto) {
        dogProfileService.createProfile(dto);
    }
}
