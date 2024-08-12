package edu.northeastern.messaging.repository.strategy;

import java.util.ArrayList;
import java.util.List;

import edu.northeastern.messaging.model.message.Message;

public class DatabasePersistence implements MessagePersistenceStrategy {

    @Override
    public void saveMessage(Message message) {
    }

    @Override
    public List<Message> getMessages() {
        return new ArrayList<>();
    }
}
