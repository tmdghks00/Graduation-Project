package com.graduation.backend.controller;

import com.graduation.backend.dto.*;
import com.graduation.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // 생성자 주입을 통해 UserService 사용
    public UserController(UserService service) {
        this.userService = service;
    }

    @PostMapping("/signup")
    // 회원가입 요청 처리 (POST /api/users/signup)
    // UserSignupRequest DTO를 받아 회원 정보 저장
    public void signup(@RequestBody UserSignupRequest request) {
        userService.signup(request);
    }

    @GetMapping("/{id}")
    // 유저 정보 조회 (GET /api/users/{id})
    // ID로 유저 정보를 조회하여 UserDto 반환
    public UserDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    // ✏유저 닉네임 수정 (PUT /api/users/{id}?nickname=새닉네임)
    public void updateNickname(@PathVariable Long id, @RequestParam String nickname) {
        userService.updateNickname(id, nickname);
    }

    @DeleteMapping("/{id}")
    // 유저 삭제 (DELETE /api/users/{id})
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/login")
    // 로그인 처리 (POST /api/users/login)
    // JWT 토큰 발급 후 LoginResponseDto 반환
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {
        String token = userService.login(request);
        return ResponseEntity.ok(new LoginResponseDto(token));
    }
}
