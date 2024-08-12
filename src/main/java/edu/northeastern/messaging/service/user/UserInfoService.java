package edu.northeastern.messaging.service.user;

import org.springframework.stereotype.Component;

import edu.northeastern.messaging.model.user.User;
import edu.northeastern.messaging.model.user.UserState;

/**
 * Service for handling user info
 */
@Component
public class UserInfoService {

    /**
     * Get the user info
     * 
     * @param username The username
     * @return The user
     */
    public User getUserInfo(String username) {
        return new User(username, UserState.ONLINE);
    }

}
