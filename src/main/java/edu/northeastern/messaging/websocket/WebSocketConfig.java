package edu.northeastern.messaging.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import edu.northeastern.messaging.config.GlobalConfig;

/**
 * Configuration for WebSocket
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Configure the message broker
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        String broker = GlobalConfig.INSTANCE.getProperty("websocket.broker.topic");
        String appPrefix = GlobalConfig.INSTANCE.getProperty("websocket.broker.app");
        config.enableSimpleBroker(broker);
        config.setApplicationDestinationPrefixes(appPrefix);
    }

    /**
     * Register the STOMP endpoints
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        String endpoint = GlobalConfig.INSTANCE.getProperty("websocket.endpoint");
        registry.addEndpoint(endpoint);
    }

}
