package com.graduation.backend.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
public class StompHandler implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
        String sessionId = accessor.getSessionId();

        switch (Objects.requireNonNull(accessor.getCommand())) {
            case CONNECT -> log.info("📡 CONNECT 요청: {}", sessionId);
            case CONNECTED -> log.info("✅ CONNECTED: {}", sessionId);
            case DISCONNECT -> log.info("❌ DISCONNECT: {}", sessionId);
            case SUBSCRIBE -> log.info("📥 SUBSCRIBE: {}", accessor.getDestination());
            case SEND -> log.info("📨 SEND: {}", accessor.getDestination());
            default -> log.info("🔄 기타: {}", accessor.getCommand());
        }

        return message;
    }
}
