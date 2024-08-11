package edu.northeastern.messaging.service.room.command;

import edu.northeastern.messaging.service.metrics.Metric;
import edu.northeastern.messaging.service.metrics.MetricsPublisherSingleton;
import edu.northeastern.messaging.service.room.Rooms;

public class JoinRoomCommand implements Command {
    private final String roomId;
    private final String userId;

    public JoinRoomCommand(String roomId, String userId) {
        this.roomId = roomId;
        this.userId = userId;
    }

    @Override
    public void execute() {
        boolean isNew = Rooms.getInstance().getRoom(roomId).addUser(userId);
        if (isNew) {
            // Publish user add metric
            MetricsPublisherSingleton.INSTANCE.get().publish(Metric.Type.USER_ADD);
        }
    }
}
