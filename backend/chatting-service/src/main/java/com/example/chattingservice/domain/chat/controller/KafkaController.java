package com.example.chattingservice.domain.chat.controller;

import com.example.chattingservice.domain.chat.dto.request.KafkaEnterChatRoomDto;
import com.example.chattingservice.domain.chat.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class KafkaController {


    private final UserService userService;

    @KafkaListener(topics="enter",groupId = "chatting-consumer")
    public void enterListener(String data) throws JsonProcessingException {
        System.out.println(data);
        userService.userEnterRoom(data);
    }
}
