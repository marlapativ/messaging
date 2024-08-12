package edu.northeastern.messaging.repository.strategy;

import java.util.ArrayList;
import java.util.List;

import edu.northeastern.messaging.model.message.Message;

/**
 * In Memory Persistence Strategy
 */
public class InMemoryPersistenceStrategy implements MessagePersistenceStrategy {
    private List<Message> messages = new ArrayList<>();

    @Override
    public void saveMessage(Message message) {
        messages.add(message);
    }

    @Override
    public List<Message> getMessages() {
        return new ArrayList<>(messages);
    }
}
