package com.graduation.backend.service;

import com.graduation.backend.dto.*;

public interface UserService {
    void signup(UserSignupRequest request); // 회원가입
    UserDto getUser(Long id); // 사용자 정보 조회
    void updateNickname(Long id, String nickname); // 닉네임 변경
    void deleteUser(Long id); // 회원 탈퇴
    String login(LoginRequestDto request); // 로그인 처리 (JWT 반환)
}
