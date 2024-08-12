package edu.northeastern.messaging.service.message.decorator;

import java.util.Arrays;
import java.util.List;

import edu.northeastern.messaging.model.message.Message;

/**
 * Profanity Filter Decorator
 */
public class ProfanityFilterDecorator extends MessageDecorator {
    private static final List<String> PROFANITY = Arrays.asList("badword1", "badword2", "badword3");

    public ProfanityFilterDecorator(Message decoratedMessage) {
        super(decoratedMessage);
    }

    @Override
    public String getContent() {
        String content = super.getContent();
        if (content == null) {
            return null;
        }
        for (String word : PROFANITY) {
            content = content.replaceAll("(?i)" + word, "*".repeat(word.length()));
        }
        return content;
    }
}
