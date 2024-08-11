package edu.northeastern.messaging.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.messaging.model.room.Room;
import edu.northeastern.messaging.model.room.RoomType;
import edu.northeastern.messaging.service.room.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping("/{roomId}/{roomType}")
    public void register(@PathVariable String roomId, @PathVariable String roomType) {
        RoomType type = RoomType.valueOf(roomType.toUpperCase());
        roomService.addRoom(roomId, type);
    }

    @GetMapping
    public Map<String, Room> get() {
        return roomService.getRooms();
    }
}
