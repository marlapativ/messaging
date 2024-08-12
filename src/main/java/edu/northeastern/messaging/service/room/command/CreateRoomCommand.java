package edu.northeastern.messaging.service.room.command;

import edu.northeastern.messaging.model.room.Room;
import edu.northeastern.messaging.model.room.RoomType;
import edu.northeastern.messaging.service.room.RoomFactory;
import edu.northeastern.messaging.service.room.Rooms;

/**
 * Create Room Command
 */
public class CreateRoomCommand implements Command {
    private final String roomId;
    private final RoomType roomType;

    public CreateRoomCommand(String roomId) {
        this.roomId = roomId;
        this.roomType = RoomType.PUBLIC;
    }

    public CreateRoomCommand(String roomId, RoomType roomType) {
        this.roomId = roomId;
        this.roomType = roomType;
    }

    @Override
    public void execute() {
        Room room = Rooms.getInstance().getRoom(roomId);
        if (room == null) {
            room = RoomFactory.create(roomType, roomId);
            Rooms.getInstance().addRoom(room);
        }
    }
}
