package edu.northeastern.messaging.service.metrics;

/**
 * Metric Interface
 */
public interface Metric extends Observer {

    public enum Type {
        USER_ADD,
        USER_REMOVE,
        MESSAGE_ADD,
        MESSAGE_REMOVE
    }

    String getName();

    int getValue();

    void increment();

    void decrement();
}
