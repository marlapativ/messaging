package edu.northeastern.messaging.service.room;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import edu.northeastern.messaging.model.message.Message;
import edu.northeastern.messaging.model.room.Room;
import edu.northeastern.messaging.model.room.RoomType;
import edu.northeastern.messaging.service.message.decorator.ProfanityFilterDecorator;
import edu.northeastern.messaging.service.message.decorator.RandomIdDecorator;
import edu.northeastern.messaging.service.room.command.CommandInvoker;
import edu.northeastern.messaging.service.room.command.CreateRoomCommand;
import edu.northeastern.messaging.service.room.command.JoinRoomCommand;
import edu.northeastern.messaging.service.room.command.SaveMessageCommand;
import edu.northeastern.messaging.service.room.command.SendMessageCommand;

@Component
public class RoomService {

    @Autowired
    SimpMessagingTemplate template;

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        addRoom("public", RoomType.PUBLIC);
    }

    public void addRoom(String roomId, RoomType roomType) {
        CommandInvoker commandInvoker = new CommandInvoker();

        commandInvoker.addCommand(new CreateRoomCommand(roomId, roomType));
        commandInvoker.executeCommands();
    }

    public void addUser(Message message) {
        CommandInvoker commandInvoker = new CommandInvoker();

        // Decorate the message with a random id and profanity filter
        message = new RandomIdDecorator(message);
        message = new ProfanityFilterDecorator(message);

        // Add the commands to the command invoker
        commandInvoker.addCommand(new CreateRoomCommand(message.getRoomId()));
        commandInvoker.addCommand(new JoinRoomCommand(message.getRoomId(), message.getSender()));
        commandInvoker.addCommand(new SendMessageCommand(template, message));
        commandInvoker.executeCommands();
    }

    public Message sendMessage(Message message) {
        CommandInvoker commandInvoker = new CommandInvoker();

        // Decorate the message with a random id and profanity filter
        message = new RandomIdDecorator(message);
        message = new ProfanityFilterDecorator(message);

        // Save the message and send it to the room
        commandInvoker.addCommand(new SaveMessageCommand(message));
        commandInvoker.addCommand(new SendMessageCommand(template, message));
        commandInvoker.executeCommands();
        return message;
    }

    public Map<String, Room> getRooms() {
        return Rooms.getInstance().getRooms();
    }
}
