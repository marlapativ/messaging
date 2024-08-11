package edu.northeastern.messaging.service.room.command;

import org.springframework.messaging.simp.SimpMessagingTemplate;

import edu.northeastern.messaging.model.message.Message;
import edu.northeastern.messaging.service.message.decorator.ProfanityFilterDecorator;
import edu.northeastern.messaging.service.metrics.Metric;
import edu.northeastern.messaging.service.metrics.MetricsService;

public class SendMessageCommand implements Command {
    private SimpMessagingTemplate simpMessagingTemplate;
    private Message message;

    public SendMessageCommand(SimpMessagingTemplate template, Message message) {
        this.simpMessagingTemplate = template;
        this.message = message;
    }

    @Override
    public void execute() {
        Message filteredMessage = new ProfanityFilterDecorator(message);
        simpMessagingTemplate.convertAndSend("/topic/" + message.getRoomId(), filteredMessage);

        // Publish message add metric
        MetricsService.PUBLISHER.get().publish(Metric.Type.MESSAGE_ADD);
    }
}
