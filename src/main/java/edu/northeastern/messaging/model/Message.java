package edu.northeastern.messaging.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private String content;
    private String sender;
    private MessageEventType type;

    public Message() {
    }

    /**
     * Constructor for the Message class.
     * 
     * @param content the content of the message
     * @param sender  the sender of the message
     * @param type    the type of the message
     */
    public Message(String content, String sender, MessageEventType type) {
        this.content = content;
        this.sender = sender;
        this.type = type;
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
        private String content;
        private String sender;
        private MessageEventType type;

        public MessageBuilder content(String content) {
            this.content = content;
            return this;
        }

        public MessageBuilder sender(String sender) {
            this.sender = sender;
            return this;
        }

        public MessageBuilder type(MessageEventType type) {
            this.type = type;
            return this;
        }

        public Message build() {
            return new Message(content, sender, type);
        }
    }
}
