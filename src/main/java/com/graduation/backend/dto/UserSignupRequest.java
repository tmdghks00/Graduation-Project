package com.graduation.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSignupRequest {
    private String email;
    private String password;
    private String nickname;
}
