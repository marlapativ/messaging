package edu.northeastern.messaging.repository;

import java.util.ArrayList;
import java.util.List;

import edu.northeastern.messaging.model.message.Message;
import edu.northeastern.messaging.repository.strategy.MessagePersistenceStrategy;

/**
 * Message Persistence Context
 */
public class MessagePersistenceContext {
    private MessagePersistenceStrategy strategy;

    /**
     * Set the message persistence strategy
     * 
     * @param strategy The message persistence strategy
     */
    public void setStrategy(MessagePersistenceStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Save a message
     * 
     * @param message The message to save
     */
    public void saveMessage(Message message) {
        if (strategy != null) {
            strategy.saveMessage(message);
        }
    }

    /**
     * Get all messages
     * 
     * @return The messages
     */
    public List<Message> getMessages() {
        if (strategy != null) {
            return strategy.getMessages();
        }
        return new ArrayList<>();
    }
}
