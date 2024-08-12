package edu.northeastern.messaging.repository.strategy;

import edu.northeastern.messaging.config.GlobalConfig;

public class MessageStrategyFactory {
    public static MessagePersistenceStrategy getStrategy() {
        String strategy = GlobalConfig.INSTANCE.getProperty("message.persistence.strategy");

        if (strategy == null) {
            return new InMemoryPersistence();
        } else if (strategy.equalsIgnoreCase("DatabasePersistence")) {
            return new DatabasePersistence();
        } else if (strategy.equalsIgnoreCase("FilePersistence")) {
            return new FilePersistence();
        }

        return new InMemoryPersistence();
    }
}
