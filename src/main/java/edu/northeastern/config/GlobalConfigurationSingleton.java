package edu.northeastern.config;

// Singleton class to hold global configuration
public class GlobalConfigurationSingleton {
    private static GlobalConfigurationSingleton INSTANCE = null;

    /**
     * Private constructor to prevent instantiation
     */
    private GlobalConfigurationSingleton() {
    }

    /**
     * Returns the singleton instance of the class
     * 
     * @return the singleton instance
     */
    public synchronized static GlobalConfigurationSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GlobalConfigurationSingleton();
        }
        return INSTANCE;
    }
}
