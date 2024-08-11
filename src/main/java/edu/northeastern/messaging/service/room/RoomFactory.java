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

    public static Room create(RoomType roomType, String id) {
        id = id == null ? UUID.randomUUID().toString() : id;
        return create(roomType, id, null);
    }

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
