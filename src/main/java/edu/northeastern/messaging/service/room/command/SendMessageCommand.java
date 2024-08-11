package edu.northeastern.messaging.service.room.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import edu.northeastern.messaging.model.message.Message;
import edu.northeastern.messaging.service.message.decorator.ProfanityFilterDecorator;

@Component
public class SendMessageCommand implements Command {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    private final Message message;

    public SendMessageCommand(Message message) {
        this.message = message;
    }

    @Override
    public void execute() {
        Message filteredMessage = new ProfanityFilterDecorator(message);
        simpMessagingTemplate.convertAndSend("/topic/" + message.getRoomId(), filteredMessage);
    }
}
