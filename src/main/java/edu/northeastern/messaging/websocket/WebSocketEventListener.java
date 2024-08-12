package edu.northeastern.messaging.websocket;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import edu.northeastern.messaging.model.message.SimpleMessage;
import edu.northeastern.messaging.model.message.MessageEventType;
import edu.northeastern.messaging.service.metrics.Metric;
import edu.northeastern.messaging.service.metrics.MetricsService;
import edu.northeastern.messaging.service.room.Rooms;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Event listener for WebSocket events
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messagingTemplate;

    /**
     * Handle the WebSocket disconnect event
     * 
     * @param event The event to handle
     */
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if (username != null) {
            log.info("user disconnected: {}", username);
            var message = SimpleMessage.builder()
                    .eventType(MessageEventType.LEAVE)
                    .sender(username)
                    .build();
            Rooms.getInstance().getRooms().forEach((k, room) -> {
                if (room.removeUser(username)) {
                    MetricsService.PUBLISHER.get().publish(Metric.Type.USER_REMOVE);
                    messagingTemplate.convertAndSend("/topic/" + room.getId(), message);
                }
            });
        }
    }
}
