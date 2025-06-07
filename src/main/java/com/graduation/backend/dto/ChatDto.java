package com.graduation.backend.dto;

import lombok.*;

// 채팅 메시지를 전달할 때 사용하는 DTO 클래스
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatDto {

    // 채팅방 ID (WebSocket 구분용 ID)
    private Long chatRoomId;

    // 메시지 보낸 사람의 이름 또는 ID
    private String sender;

    // 전달할 채팅 메시지 내용
    private String message;
}
