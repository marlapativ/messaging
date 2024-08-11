package edu.northeastern.messaging.websocket;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import edu.northeastern.messaging.model.message.SimpleMessage;
import edu.northeastern.messaging.model.message.MessageEventType;
import edu.northeastern.messaging.service.room.Rooms;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if (username != null) {
            log.info("user disconnected: {}", username);
            var message = SimpleMessage.builder()
                    .type(MessageEventType.LEAVE)
                    .sender(username)
                    .build();
            Rooms.getInstance().getRooms().forEach((k, room) -> {
                if (room.containsUser(username)) {
                    room.removeUser(username);
                    messagingTemplate.convertAndSend("/topic/" + room.getId(), message);
                }
            });
        }
    }
}
