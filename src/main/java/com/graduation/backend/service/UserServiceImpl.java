package com.graduation.backend.service;

import com.graduation.backend.dto.*;
import com.graduation.backend.entity.User;
import com.graduation.backend.repository.UserRepository;
import com.graduation.backend.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder encoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    // 회원가입 처리 (비밀번호 암호화 및 "local" provider 설정)
    @Override
    public void signup(UserSignupRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .nickname(request.getNickname())
                .provider("local")
                .build();
        userRepository.save(user);
    }

    // 사용자 ID로 정보 조회 후 DTO로 변환
    @Override
    public UserDto getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("사용자 없음"));
        return new UserDto(user.getEmail(), user.getNickname());
    }

    // 닉네임 수정
    @Override
    public void updateNickname(Long id, String nickname) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("사용자 없음"));
        user.setNickname(nickname);
        userRepository.save(user);
    }

    // 회원 탈퇴
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // 로그인 처리: 이메일 존재 여부 확인 → 비밀번호 검증 → JWT 생성 후 반환
    @Override
    public String login(LoginRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("해당 이메일이 존재하지 않습니다."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        return jwtUtil.createToken(user.getEmail());
    }
}
