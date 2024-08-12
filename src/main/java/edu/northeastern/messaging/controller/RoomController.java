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

/**
 * Controller for handling room related requests
 */
@RestController
@RequestMapping("/rooms")
public class RoomController {

    /**
     * Service for handling room related operations
     */
    @Autowired
    RoomService roomService;

    /**
     * Register a room
     * 
     * @param roomId   The room id
     * @param roomType The room type
     */
    @PostMapping("/{roomId}/{roomType}")
    public void register(@PathVariable String roomId, @PathVariable String roomType) {
        RoomType type = RoomType.valueOf(roomType.toUpperCase());
        roomService.addRoom(roomId, type);
    }

    /**
     * Get the rooms
     * 
     * @return The rooms
     */
    @GetMapping
    public Map<String, Room> get() {
        return roomService.getRooms();
    }
}
