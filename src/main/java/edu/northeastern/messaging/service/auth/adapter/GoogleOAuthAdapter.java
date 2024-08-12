package edu.northeastern.messaging.service.auth.adapter;

import edu.northeastern.messaging.service.auth.AuthService;
import edu.northeastern.messaging.service.auth.client.GoogleOAuthClient;

/**
 * Google OAuth Adapter
 */
public class GoogleOAuthAdapter implements AuthService {
    private GoogleOAuthClient googleOAuthClient;

    /**
     * Constructor for the GoogleOAuthAdapter class.
     * 
     * @param googleOAuthClient the Google OAuth client
     */
    public GoogleOAuthAdapter(GoogleOAuthClient googleOAuthClient) {
        this.googleOAuthClient = googleOAuthClient;
    }

    /**
     * Authenticate
     * 
     * @param credential the credential to authenticate
     * @return true if the credential is authenticated, false otherwise
     */
    @Override
    public boolean authenticate(String credential) {
        return googleOAuthClient.verifyToken(credential);
    }
}
