package edu.northeastern.messaging.repository;

import java.util.ArrayList;
import java.util.List;

import edu.northeastern.messaging.model.message.Message;
import edu.northeastern.messaging.repository.strategy.MessagePersistenceStrategy;

public class MessagePersistenceContext {
    private MessagePersistenceStrategy strategy;

    public void setStrategy(MessagePersistenceStrategy strategy) {
        this.strategy = strategy;
    }

    public void saveMessage(Message message) {
        if (strategy != null) {
            strategy.saveMessage(message);
        }
    }

    public List<Message> getMessages() {
        if (strategy != null) {
            return strategy.getMessages();
        }
        return new ArrayList<>();
    }
}
