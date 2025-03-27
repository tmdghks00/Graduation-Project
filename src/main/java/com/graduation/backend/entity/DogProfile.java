package com.graduation.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DogProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String personality;
    private boolean neutered;

    public DogProfile(com.graduation.backend.dto.DogProfileDto dto) {
        this.name = dto.getName();
        this.age = dto.getAge();
        this.personality = dto.getPersonality();
        this.neutered = dto.isNeutered();
    }
}
