package edu.northeastern.messaging.service.room.command;

import edu.northeastern.messaging.service.metrics.Metric;
import edu.northeastern.messaging.service.metrics.MetricsService;
import edu.northeastern.messaging.service.room.Rooms;

/**
 * Join Room Command
 */
public class JoinRoomCommand implements Command {
    private final String roomId;
    private final String userId;

    public JoinRoomCommand(String roomId, String userId) {
        this.roomId = roomId;
        this.userId = userId;
    }

    @Override
    public void execute() {
        var room = Rooms.getInstance().getRoom(roomId);
        if (room == null) {
            return;
        }
        boolean isNew = room.addUser(userId);
        if (isNew) {
            // Publish user add metric
            MetricsService.PUBLISHER.get().publish(Metric.Type.USER_ADD);
        }
    }
}
