package edu.northeastern.messaging.model.room;

/**
 * Private Room Entity
 */
public class PrivateRoom extends Room {
    public PrivateRoom(String id, String name) {
        super(id, name);
    }

    @Override
    public RoomType getType() {
        return RoomType.PRIVATE;
    }
}
