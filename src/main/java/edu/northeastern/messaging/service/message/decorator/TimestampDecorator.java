package edu.northeastern.messaging.service.message.decorator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import edu.northeastern.messaging.model.message.Message;

@Component
public class TimestampDecorator extends MessageDecorator {
    public TimestampDecorator(Message decoratedMessage) {
        super(decoratedMessage);
    }

    @Override
    public String getContent() {
        return "[" + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME) + "] " + super.getContent();
    }
}
