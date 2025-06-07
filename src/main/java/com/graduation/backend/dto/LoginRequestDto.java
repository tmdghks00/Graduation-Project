package com.graduation.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

// 로그인 요청 시 클라이언트가 서버에 전달하는 데이터를 담는 DTO
@Getter
@NoArgsConstructor
public class LoginRequestDto {

    // 사용자의 이메일
    private String email;

    // 사용자의 비밀번호
    private String password;
}
