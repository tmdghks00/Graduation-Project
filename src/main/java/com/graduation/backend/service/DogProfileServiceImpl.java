package com.graduation.backend.service;

import com.graduation.backend.dto.DogProfileDto;
import com.graduation.backend.entity.DogProfile;
import com.graduation.backend.repository.DogProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class DogProfileServiceImpl implements DogProfileService {

    private final DogProfileRepository repository;

    public DogProfileServiceImpl(DogProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createProfile(DogProfileDto dto) {
        DogProfile profile = new DogProfile(dto);
        repository.save(profile);
    }
}
