package edu.northeastern.messaging.model.message;

import lombok.Getter;

/**
 * SimpleMessage Entity
 */
@Getter
public class SimpleMessage implements Message {
    private String id;
    private String content;
    private String sender;
    private String roomId;
    private MessageEventType eventType;

    public SimpleMessage() {
    }

    /**
     * Constructor for the Message class.
     * 
     * @param content   the content of the message
     * @param sender    the sender of the message
     * @param eventType the event type of the message
     */
    public SimpleMessage(String id, String roomId, String content, String sender, MessageEventType eventType) {
        this.content = content;
        this.sender = sender;
        this.eventType = eventType;
    }

    @Override
    public SimpleMessage clone() {
        return new SimpleMessage(id, roomId, content, sender, eventType);
    }

    /**
     * Static factory method to create a new instance of the MessageBuilder class.
     *
     * @return a new instance of the MessageBuilder class
     */
    public static MessageBuilder builder() {
        return new MessageBuilder();
    }

    /**
     * Builder class for the Message class.
     */
    public static class MessageBuilder {
        private String id;
        private String roomId;
        private String content;
        private String sender;
        private MessageEventType eventType;

        public MessageBuilder content(String content) {
            this.content = content;
            return this;
        }

        public MessageBuilder sender(String sender) {
            this.sender = sender;
            return this;
        }

        public MessageBuilder eventType(MessageEventType eventType) {
            this.eventType = eventType;
            return this;
        }

        public MessageBuilder roomId(String roomId) {
            this.roomId = roomId;
            return this;
        }

        public MessageBuilder id(String id) {
            this.id = id;
            return this;
        }

        public SimpleMessage build() {
            return new SimpleMessage(id, roomId, content, sender, eventType);
        }
    }
}
