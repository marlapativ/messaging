package edu.northeastern.messaging.service.room;

import java.util.HashMap;

import edu.northeastern.messaging.model.room.Room;

/**
 * Rooms Singleton
 */
public class Rooms {
    private static Rooms INSTANCE;
    private HashMap<String, Room> rooms;

    /**
     * Private constructor
     */
    private Rooms() {
        rooms = new HashMap<>();
    }

    /**
     * Get the singleton instance
     * 
     * @return
     */
    public static Rooms getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Rooms();
        }
        return INSTANCE;
    }

    /**
     * Add a room
     * 
     * @param room The room to add
     */
    public void addRoom(Room room) {
        if (room == null || rooms.containsKey(room.getId())) {
            return;
        }
        rooms.put(room.getId(), room);
    }

    /**
     * Get a room
     * 
     * @param id The id of the room
     * @return The room
     */
    public Room getRoom(String id) {
        return rooms.get(id);
    }

    /**
     * Remove a room
     * 
     * @param id The id of the room
     */
    public void removeRoom(String id) {
        rooms.remove(id);
    }

    /**
     * Get the rooms
     * 
     * @return The rooms
     */
    public HashMap<String, Room> getRooms() {
        return rooms;
    }

    /**
     * Clear the rooms
     */
    public void clear() {
        rooms.clear();
    }
}
