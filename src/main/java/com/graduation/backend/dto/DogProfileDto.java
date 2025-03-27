package com.graduation.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DogProfileDto {
    private String name;
    private int age;
    private String personality;
    private boolean neutered;
}
