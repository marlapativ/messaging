package edu.northeastern.messaging.service.room;

import java.util.UUID;

import edu.northeastern.messaging.model.room.PrivateRoom;
import edu.northeastern.messaging.model.room.PublicRoom;
import edu.northeastern.messaging.model.room.Room;
import edu.northeastern.messaging.model.room.RoomType;

public class RoomFactory {

    public static Room create(RoomType roomType) {
        return create(roomType, null);
    }

    public static Room create(RoomType roomType, String roomName) {
        String id = UUID.randomUUID().toString();
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
