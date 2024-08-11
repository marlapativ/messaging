package edu.northeastern.messaging.service.message.decorator;

import edu.northeastern.messaging.model.message.Message;
import edu.northeastern.messaging.model.message.MessageEventType;

public abstract class MessageDecorator implements Message {
    protected Message decoratedMessage;

    public MessageDecorator(Message decoratedMessage) {
        this.decoratedMessage = decoratedMessage;
    }

    @Override
    public String getContent() {
        return decoratedMessage.getContent();
    }

    @Override
    public String getSender() {
        return decoratedMessage.getSender();
    }

    @Override
    public String getRoomId() {
        return decoratedMessage.getRoomId();
    }

    @Override
    public MessageEventType getEventType() {
        return decoratedMessage.getEventType();
    }
}
