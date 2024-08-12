package edu.northeastern.messaging.service.room.command;

import edu.northeastern.messaging.model.room.Room;
import edu.northeastern.messaging.service.metrics.Metric;
import edu.northeastern.messaging.service.metrics.MetricsService;
import edu.northeastern.messaging.service.room.Rooms;

/**
 * Leave Room Command
 */
public class LeaveRoomCommand implements Command {
    private final String roomId;
    private final String userId;

    public LeaveRoomCommand(String roomId, String userId) {
        this.roomId = roomId;
        this.userId = userId;
    }

    @Override
    public void execute() {
        Room room = Rooms.getInstance().getRoom(roomId);
        if (room == null) {
            return;
        }
        boolean isSuccess = room.removeUser(userId);
        if (isSuccess) {
            MetricsService.PUBLISHER.get().publish(Metric.Type.USER_REMOVE);
        }
    }
}
