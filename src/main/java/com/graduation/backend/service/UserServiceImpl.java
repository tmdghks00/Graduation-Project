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

    @Override
    public UserDto getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("사용자 없음"));
        return new UserDto(user.getEmail(), user.getNickname());
    }

    @Override
    public void updateNickname(Long id, String nickname) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("사용자 없음"));
        user.setNickname(nickname);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

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
