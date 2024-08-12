package edu.northeastern.messaging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import edu.northeastern.messaging.model.message.Message;
import edu.northeastern.messaging.model.message.SimpleMessage;
import edu.northeastern.messaging.service.room.RoomService;

@Controller
public class MessagingController {

    @Autowired
    RoomService roomService;

    @MessageMapping("/chat.register")
    public Message register(@Payload SimpleMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        var attributes = headerAccessor.getSessionAttributes();
        if (attributes != null) {
            attributes.put("username", chatMessage.getSender());
            roomService.addUser(chatMessage);
        }
        return chatMessage;

    }

    @MessageMapping("/chat.send")
    public Message sendMessage(@Payload SimpleMessage chatMessage) {
        return roomService.sendMessage(chatMessage);
    }
}
