package edu.northeastern.messaging.service.auth.adapter;

import edu.northeastern.messaging.service.auth.AuthService;
import edu.northeastern.messaging.service.auth.client.GoogleOAuthClient;

public class GoogleOAuthAdapter implements AuthService {
    private GoogleOAuthClient googleOAuthClient;

    public GoogleOAuthAdapter(GoogleOAuthClient googleOAuthClient) {
        this.googleOAuthClient = googleOAuthClient;
    }

    @Override
    public boolean authenticate(String credential) {
        return googleOAuthClient.verifyToken(credential);
    }
}
