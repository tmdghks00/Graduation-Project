package com.graduation.backend.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 사용자 정보를 저장하는 엔티티
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    // 사용자 고유 ID (자동 증가)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 사용자 이메일
    private String email;

    // 사용자 닉네임
    private String nickname;

    // 비밀번호 (로컬 로그인 시 사용)
    private String password;

    // 가입한 소셜 제공자 정보 (google, kakao, local 등)
    private String provider;
}
