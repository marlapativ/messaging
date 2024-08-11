package edu.northeastern.messaging.config;

import java.io.InputStream;
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
        try (InputStream stream = GlobalConfiguration.class.getClassLoader()
                .getResourceAsStream("application.properties");) {
            properties.load(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        System.out.println(properties.keySet());
        return properties.getProperty(key);
    }
}
