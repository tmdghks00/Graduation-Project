package com.graduation.backend.config;

import com.graduation.backend.util.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeHttpRequests(auth -> auth
                        // Swagger UI 허용
                        .requestMatchers("/", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll()
                        // WebSocket 및 SockJS 허용
                        .requestMatchers(
                                "/ws-stomp/**",              // WebSocket과 SockJS 통합 엔드포인트
                                "/stomp-chat-test.html"      // 테스트 HTML 페이지
                        ).permitAll()
                        // 회원 API
                        .requestMatchers("/api/users/**").permitAll()
                        // 나머지는 인증 필요
                        .anyRequest().authenticated()
                )
                .addFilterBefore(new JwtAuthenticationFilter(jwtUtil()), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
