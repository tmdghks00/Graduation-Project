package com.graduation.backend.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 강아지 프로필 정보를 저장하는 엔티티
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DogProfile {

    // 기본 키 (자동 증가 ID)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 강아지 이름
    private String name;

    // 강아지 나이
    private int age;

    // 성격 설명
    private String personality;

    // 중성화 여부
    private boolean neutered;

    // DTO를 엔티티로 변환하는 생성자
    public DogProfile(com.graduation.backend.dto.DogProfileDto dto) {
        this.name = dto.getName();
        this.age = dto.getAge();
        this.personality = dto.getPersonality();
        this.neutered = dto.isNeutered();
    }
}
