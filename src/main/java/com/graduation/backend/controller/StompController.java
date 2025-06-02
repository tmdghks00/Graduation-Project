package com.graduation.backend.controller;

import com.graduation.backend.dto.ChatDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class StompController {

    @MessageMapping("/chat/{chatRoomId}")       // 클라이언트 → 서버로 /pub/chat/1 전송 시 매핑
    @SendTo("/sub/chat/{chatRoomId}")           // 서버 → 클라이언트 브로드캐스트 경로
    public ChatDto sendMessage(
            @DestinationVariable Long chatRoomId,
            @Payload ChatDto chatDto
    ) {
        log.info("💬 [Room {}] {}: {}", chatRoomId, chatDto.getSender(), chatDto.getMessage());
        return chatDto;  // 메시지를 그대로 구독 경로로 전송
    }
}
