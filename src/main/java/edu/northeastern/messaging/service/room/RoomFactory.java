package edu.northeastern.messaging.service.room;

import java.util.UUID;

import edu.northeastern.messaging.model.room.PrivateRoom;
import edu.northeastern.messaging.model.room.PublicRoom;
import edu.northeastern.messaging.model.room.Room;
import edu.northeastern.messaging.model.room.RoomType;

public class RoomFactory {

    /**
     * Create a room
     * 
     * @param roomType the room type
     * @return the room
     */
    public static Room create(RoomType roomType) {
        return create(roomType, null);
    }

    /**
     * Create a room
     * 
     * @param roomType the room type
     * @param id       the room id
     * @return the room
     */
    public static Room create(RoomType roomType, String id) {
        id = id == null ? UUID.randomUUID().toString() : id;
        return create(roomType, id, null);
    }

    /**
     * Create a room
     * 
     * @param roomType the room type
     * @param id       the room id
     * @param roomName the room name
     * @return the room
     */
    public static Room create(RoomType roomType, String id, String roomName) {
        switch (roomType) {
            case PRIVATE:
                return new PrivateRoom(id, roomName == null ? "Private Room" : roomName);
            case PUBLIC:
                return new PublicRoom(id, roomName == null ? "Public Room" : roomName);
            default:
                return null;
        }
    }
}
