package com.graduation.backend.dto;

import com.graduation.backend.entity.DogProfile;
import lombok.*;

// 강아지 프로필 정보를 담는 DTO 클래스
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DogProfileDto {

    private Long id;
    private Long userId;
    private String name;
    private String breed;
    private int age;
    private String gender;
    private String imageUrl;

    // Entity → DTO 변환
    public static DogProfileDto from(DogProfile dog) {
        return new DogProfileDto(
                dog.getId(),
                dog.getUser().getId(),
                dog.getName(),
                dog.getBreed(),
                dog.getAge(),
                dog.getGender(),
                dog.getImageUrl()
        );
    }
}
