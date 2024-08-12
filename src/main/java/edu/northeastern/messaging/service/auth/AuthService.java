package edu.northeastern.messaging.service.auth;

/**
 * Auth Service Interface
 */
public interface AuthService {

    /**
     * Authenticate
     * 
     * @param credential the credential to authenticate
     * @return true if the credential is authenticated, false otherwise
     */
    boolean authenticate(String credential);
}
