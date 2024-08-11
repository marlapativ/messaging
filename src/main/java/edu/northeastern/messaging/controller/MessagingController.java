package edu.northeastern.messaging.controller;

import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import edu.northeastern.messaging.model.message.Message;
import edu.northeastern.messaging.service.room.RoomService;

@Controller
public class MessagingController {

    SimpMessagingTemplate simpMessagingTemplate;

    RoomService roomService;

    @MessageMapping("/chat.register")
    public Message register(@Payload Message chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        var attributes = headerAccessor.getSessionAttributes();
        if (attributes != null) {
            attributes.put("username", chatMessage.getSender());
            roomService.addUser(chatMessage);
        }
        return chatMessage;

    }

    @MessageMapping("/chat.send")
    public Message sendMessage(@Payload Message chatMessage) {
        return roomService.sendMessage(chatMessage);
    }
}
