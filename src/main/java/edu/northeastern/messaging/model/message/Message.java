package edu.northeastern.messaging.model.message;

public interface Message {
    String getContent();

    String getSender();

    String getRoomId();

    MessageEventType getType();
}
