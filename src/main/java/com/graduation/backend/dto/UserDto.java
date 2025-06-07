package com.graduation.backend.dto;

import lombok.*;

// 서버에서 사용자 정보를 조회하여 클라이언트에게 전달할 때 사용하는 DTO
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    // 사용자 이메일
    private String email;

    // 사용자 닉네임
    private String nickname;
}
