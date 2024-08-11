package edu.northeastern.messaging.service.room;

import java.util.HashMap;

import edu.northeastern.messaging.model.room.Room;

public class Rooms {
    private static Rooms INSTANCE;
    private HashMap<String, Room> rooms;

    private Rooms() {
        rooms = new HashMap<>();
    }

    public static Rooms getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Rooms();
        }
        return INSTANCE;
    }

    public void addRoom(Room room) {
        if (room == null || rooms.containsKey(room.getId())) {
            return;
        }
        rooms.put(room.getId(), room);
    }

    public Room getRoom(String id) {
        return rooms.get(id);
    }

    public void removeRoom(String id) {
        rooms.remove(id);
    }

    public HashMap<String, Room> getRooms() {
        return rooms;
    }

    public void clear() {
        rooms.clear();
    }
}
