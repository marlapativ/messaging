package edu.northeastern.messaging.service.message.decorator;

import java.util.UUID;

import edu.northeastern.messaging.model.message.Message;

/**
 * Random Id Decorator
 */
public class RandomIdDecorator extends MessageDecorator {
    public RandomIdDecorator(Message decoratedMessage) {
        super(decoratedMessage);
    }

    @Override
    public String getId() {
        return UUID.randomUUID().toString();
    }
}
