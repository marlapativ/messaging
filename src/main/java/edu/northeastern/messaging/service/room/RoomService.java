package edu.northeastern.messaging.service.room;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import edu.northeastern.messaging.model.room.Room;
import edu.northeastern.messaging.model.room.RoomType;

@Component
public class RoomService {

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        Room defaultPublicRoom = RoomFactory.create(RoomType.PUBLIC);
        Rooms.getInstance().addRoom(defaultPublicRoom);
    }
}
