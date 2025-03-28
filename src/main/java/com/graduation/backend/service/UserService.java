package com.graduation.backend.service;

import com.graduation.backend.dto.*;

public interface UserService {
    void signup(UserSignupRequest request);
    UserDto getUser(Long id);
    void updateNickname(Long id, String nickname);
    void deleteUser(Long id);

    String login(LoginRequestDto request);

}
