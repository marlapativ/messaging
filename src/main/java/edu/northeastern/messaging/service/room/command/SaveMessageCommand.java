package edu.northeastern.messaging.service.room.command;

import edu.northeastern.messaging.model.message.Message;
import edu.northeastern.messaging.repository.MessagePersistenceContext;
import edu.northeastern.messaging.repository.strategy.MessageStrategyFactory;

/**
 * Save Message Command
 */
public class SaveMessageCommand implements Command {
    private final Message message;
    private final MessagePersistenceContext persistenceContext;

    public SaveMessageCommand(Message message) {
        this.message = message;
        this.persistenceContext = new MessagePersistenceContext();
        var strategy = MessageStrategyFactory.getStrategy();
        persistenceContext.setStrategy(strategy);
    }

    @Override
    public void execute() {
        persistenceContext.saveMessage(message);
    }
}
