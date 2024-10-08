package edu.northeastern.messaging.repository.strategy;

import java.util.List;

import edu.northeastern.messaging.model.message.Message;

/**
 * Message Persistence Strategy
 */
public interface MessagePersistenceStrategy {
    void saveMessage(Message message);

    List<Message> getMessages();
}
