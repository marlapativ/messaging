package edu.northeastern.messaging.service.auth.adapter;

import edu.northeastern.messaging.repository.UserRepository;
import edu.northeastern.messaging.service.auth.AuthService;

public class UsernamePasswordAdapter implements AuthService {
    private UserRepository userRepository;

    public UsernamePasswordAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean authenticate(String credentials) {
        String[] parts = credentials.split(":");
        String username = parts[0];
        String password = parts[1];
        return userRepository.verifyCredentials(username, password);
    }
}
