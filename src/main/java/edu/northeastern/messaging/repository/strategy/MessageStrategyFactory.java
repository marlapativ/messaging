package edu.northeastern.messaging.repository.strategy;

import edu.northeastern.messaging.config.GlobalConfig;

public class MessageStrategyFactory {
    public static MessagePersistenceStrategy getStrategy() {
        String strategy = GlobalConfig.INSTANCE.getProperty("message.persistence.strategy");

        if (strategy == null) {
            return new InMemoryPersistenceStrategy();
        } else if (strategy.equalsIgnoreCase("DatabasePersistence")) {
            return new DatabasePersistenceStrategy();
        } else if (strategy.equalsIgnoreCase("FilePersistence")) {
            return new FilePersistenceStrategy();
        }

        return new InMemoryPersistenceStrategy();
    }
}
