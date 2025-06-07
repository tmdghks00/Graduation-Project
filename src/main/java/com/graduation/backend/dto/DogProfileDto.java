package com.graduation.backend.dto;

import lombok.*;

// 강아지 프로필 정보를 담는 DTO 클래스
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DogProfileDto {

    // 강아지 이름
    private String name;

    // 강아지 나이
    private int age;

    // 강아지 성격 설명 (ex. 활발함, 차분함 등)
    private String personality;

    // 중성화 여부 (true: 중성화됨, false: 안됨)
    private boolean neutered;
}
