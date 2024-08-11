package edu.northeastern.messaging.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.northeastern.messaging.model.room.RoomType;
import edu.northeastern.messaging.service.room.RoomService;

@Controller
public class RoomController {

    RoomService roomService;

    @PostMapping("/rooms/{roomId}/{roomType}")
    public void register(@PathVariable String roomId, @PathVariable String roomType) {
        RoomType type = RoomType.valueOf(roomType.toUpperCase());
        roomService.addRoom(roomId, type);
    }
}
