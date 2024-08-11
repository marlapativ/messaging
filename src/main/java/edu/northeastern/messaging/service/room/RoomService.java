package edu.northeastern.messaging.service.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import edu.northeastern.messaging.model.message.Message;
import edu.northeastern.messaging.model.room.Room;
import edu.northeastern.messaging.model.room.RoomType;

@Component
public class RoomService {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        Room defaultPublicRoom = RoomFactory.create(RoomType.PUBLIC, "public");
        Rooms.getInstance().addRoom(defaultPublicRoom);
    }

    public void addRoom(String roomId, String roomType) {
        RoomType type = RoomType.valueOf(roomType.toUpperCase());
        Room room = RoomFactory.create(type, roomId);
        Rooms.getInstance().addRoom(room);
    }

    public Room addUser(Message message) {
        String userId = message.getSender();
        String roomId = message.getRoomId();
        Room room = Rooms.getInstance().getRoom(roomId);
        if (room == null) {
            room = RoomFactory.create(RoomType.PUBLIC, roomId);
            Rooms.getInstance().addRoom(room);
        }

        room.addUser(userId);
        simpMessagingTemplate.convertAndSend("/topic/" + room.getId(), message);
        return room;
    }

    public Message sendMessage(Message chatMessage) {
        simpMessagingTemplate.convertAndSend("/topic/" + chatMessage.getRoomId(), chatMessage);
        return chatMessage;
    }
}
