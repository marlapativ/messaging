package edu.northeastern.messaging.model.room;

public class PublicRoom extends Room {
    public PublicRoom(String id, String name) {
        super(id, name);
    }

    @Override
    public RoomType getType() {
        return RoomType.PUBLIC;
    }
}
