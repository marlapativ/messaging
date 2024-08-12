package edu.northeastern.messaging.model.message;

public interface Message extends Cloneable {
    String getId();

    String getContent();

    String getSender();

    String getRoomId();

    MessageEventType getEventType();
}
