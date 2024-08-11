package edu.northeastern.messaging.service.message.decorator;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import edu.northeastern.messaging.model.message.Message;

@Component
public class ProfanityFilterDecorator extends MessageDecorator {
    private static final List<String> PROFANITY = Arrays.asList("badword1", "badword2", "badword3");

    public ProfanityFilterDecorator(Message decoratedMessage) {
        super(decoratedMessage);
    }

    @Override
    public String getContent() {
        String content = super.getContent();
        for (String word : PROFANITY) {
            content = content.replaceAll("(?i)" + word, "*".repeat(word.length()));
        }
        return content;
    }
}
