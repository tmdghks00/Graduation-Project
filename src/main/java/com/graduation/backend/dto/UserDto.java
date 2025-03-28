package com.graduation.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto { // 서버에서 사용자 정보를 조회해서 클라이언트에 보내줄 때 사용
    private String email;
    private String nickname;
}
