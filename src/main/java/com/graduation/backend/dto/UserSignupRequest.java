package com.graduation.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSignupRequest { // 회원가입 시 보내는 데이터를 담음
    private String email;
    private String password;
    private String nickname;
}
