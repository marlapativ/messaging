package edu.northeastern.messaging.service.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.northeastern.messaging.repository.UserRepository;
import edu.northeastern.messaging.service.auth.adapter.GoogleOAuthAdapter;
import edu.northeastern.messaging.service.auth.adapter.UsernamePasswordAdapter;
import edu.northeastern.messaging.service.auth.client.GoogleOAuthClient;

/**
 * Security Configuration
 */
@Configuration
public class SecurityConfig {
    @Bean
    public AuthService googleOAuthService() {
        return new GoogleOAuthAdapter(new GoogleOAuthClient());
    }

    @Bean
    public AuthService usernamePasswordService() {
        return new UsernamePasswordAdapter(new UserRepository());
    }
}
