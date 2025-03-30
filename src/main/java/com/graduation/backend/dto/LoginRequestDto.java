package com.graduation.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequestDto {
    private String email; // 이메일
    private String password; // 비밀번호
}
