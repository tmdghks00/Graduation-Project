package com.graduation.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatDto {
    private Long chatRoomId;
    private String sender;
    private String message;
}
