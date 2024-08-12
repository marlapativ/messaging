package edu.northeastern.messaging.service.room.command;

import org.springframework.messaging.simp.SimpMessagingTemplate;

import edu.northeastern.messaging.model.message.Message;
import edu.northeastern.messaging.model.message.MessageEventType;
import edu.northeastern.messaging.service.metrics.Metric;
import edu.northeastern.messaging.service.metrics.MetricsService;

/**
 * Send Message Command
 */
public class SendMessageCommand implements Command {
    private SimpMessagingTemplate simpMessagingTemplate;
    private Message message;

    public SendMessageCommand(SimpMessagingTemplate template, Message message) {
        this.simpMessagingTemplate = template;
        this.message = message;
    }

    @Override
    public void execute() {
        if (message == null) {
            return;
        }

        simpMessagingTemplate.convertAndSend("/topic/" + message.getRoomId(), message);

        // Publish message add metric
        if (message.getEventType() == MessageEventType.CHAT) {
            MetricsService.PUBLISHER.get().publish(Metric.Type.MESSAGE_ADD);
        }
    }
}
