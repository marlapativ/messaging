package edu.northeastern.messaging.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import edu.northeastern.messaging.config.GlobalConfiguration;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        String broker = GlobalConfiguration.INSTANCE.getProperty("websocket.broker.topic");
        String appPrefix = GlobalConfiguration.INSTANCE.getProperty("websocket.broker.app");
        config.enableSimpleBroker(broker);
        config.setApplicationDestinationPrefixes(appPrefix);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        String endpoint = GlobalConfiguration.INSTANCE.getProperty("websocket.endpoint");
        registry.addEndpoint(endpoint);
    }

}
