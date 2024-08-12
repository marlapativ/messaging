package edu.northeastern.messaging.config;

import java.io.InputStream;
import java.util.Properties;

// Singleton class to hold global configuration
public enum GlobalConfig {
    INSTANCE;

    private Properties properties;

    /**
     * Private constructor to prevent instantiation
     */
    private GlobalConfig() {
        properties = new Properties();
        try (InputStream stream = GlobalConfig.class.getClassLoader()
                .getResourceAsStream("application.properties");) {
            properties.load(stream);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    /**
     * Get the property value for the given key
     * 
     * @param key The key to get the value for
     * @return The value for the given key
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
