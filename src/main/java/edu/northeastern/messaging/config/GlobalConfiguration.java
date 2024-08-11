package edu.northeastern.messaging.config;

import java.io.FileReader;
import java.util.Properties;

// Singleton class to hold global configuration
public enum GlobalConfiguration {
    INSTANCE;

    private Properties properties;

    /**
     * Private constructor to prevent instantiation
     */
    private GlobalConfiguration() {
        properties = new Properties();
        try (FileReader reader = new FileReader("resources/config.properties")) {
            properties.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
