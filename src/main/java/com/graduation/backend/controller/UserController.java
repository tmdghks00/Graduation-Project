package com.graduation.backend.controller;

import com.graduation.backend.dto.*;
import com.graduation.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService service) {
        this.userService = service;
    }

    @PostMapping("/signup")
    public void signup(@RequestBody UserSignupRequest request) {
        userService.signup(request);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public void updateNickname(@PathVariable Long id, @RequestParam String nickname) {
        userService.updateNickname(id, nickname);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {
        String token = userService.login(request);
        return ResponseEntity.ok(new LoginResponseDto(token));
    }

}
