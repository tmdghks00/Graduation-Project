package com.graduation.backend.dto;

import lombok.*;

// 회원가입 시 클라이언트가 서버에 전달하는 요청 데이터를 담는 DTO
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSignupRequest {

    // 사용자 이메일
    private String email;

    // 사용자 비밀번호
    private String password;

    // 사용자 닉네임
    private String nickname;
}
