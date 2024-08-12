package edu.northeastern.messaging.model.message;

/**
 * Message Entity
 */
public interface Message extends Cloneable {
    /**
     * Get the id of the message
     * 
     * @return The id of the message
     */
    String getId();

    /**
     * Get the content of the message
     * 
     * @return The content of the message
     */
    String getContent();

    /**
     * Get the sender of the message
     * 
     * @return The sender of the message
     */
    String getSender();

    /**
     * Get the room id of the message
     * 
     * @return The room id of the message
     */
    String getRoomId();

    /**
     * Get the timestamp of the message
     * 
     * @return The timestamp of the message
     */
    MessageEventType getEventType();
}
