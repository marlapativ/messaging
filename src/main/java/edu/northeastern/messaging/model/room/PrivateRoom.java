package edu.northeastern.messaging.model.room;

public class PrivateRoom extends Room {
    public PrivateRoom(String id, String name) {
        super(id, name);
    }

    @Override
    public RoomType getType() {
        return RoomType.PRIVATE;
    }
}
