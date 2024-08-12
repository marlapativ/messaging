package edu.northeastern.messaging.service.message.decorator;

import edu.northeastern.messaging.model.message.Message;
import edu.northeastern.messaging.model.message.MessageEventType;

/**
 * Message Decorator
 */
public abstract class MessageDecorator implements Message {
    protected Message decoratedMessage;

    /**
     * Constructor for the MessageDecorator class.
     * 
     * @param decoratedMessage the message to decorate
     */
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
    public String getId() {
        return decoratedMessage.getId();
    }

    @Override
    public MessageEventType getEventType() {
        return decoratedMessage.getEventType();
    }
}
