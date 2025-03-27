package com.graduation.backend.repository;

import com.graduation.backend.entity.DogProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogProfileRepository extends JpaRepository<DogProfile, Long> {
}
