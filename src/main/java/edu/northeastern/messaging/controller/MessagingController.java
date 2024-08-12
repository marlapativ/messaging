package edu.northeastern.messaging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import edu.northeastern.messaging.model.message.Message;
import edu.northeastern.messaging.model.message.SimpleMessage;
import edu.northeastern.messaging.service.room.RoomService;

/**
 * Controller for handling messaging related requests
 */
@Controller
public class MessagingController {

    /**
     * Service for handling room related operations
     */
    @Autowired
    RoomService roomService;

    /**
     * Register a user to the chat room
     * 
     * @param chatMessage    The message containing the user information
     * @param headerAccessor The header accessor for the message
     * @return The message containing the chat information
     */
    @MessageMapping("/chat.register")
    public Message register(@Payload SimpleMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        var attributes = headerAccessor.getSessionAttributes();
        if (attributes != null) {
            attributes.put("username", chatMessage.getSender());
            roomService.addUser(chatMessage);
        }
        return chatMessage;

    }

    /**
     * Send a message to the chat room
     * 
     * @param chatMessage The message to send
     * @return The message containing the chat information
     */
    @MessageMapping("/chat.send")
    public Message sendMessage(@Payload SimpleMessage chatMessage) {
        return roomService.sendMessage(chatMessage);
    }
}
