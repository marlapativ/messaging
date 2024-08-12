package edu.northeastern.messaging.service.user;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import edu.northeastern.messaging.model.user.UserState;

/**
 * Service for handling user state
 */
@Component
public class UserStateService {

    private HashMap<String, UserState> userStateMap;

    public UserStateService() {
        userStateMap = new HashMap<>();
    }

    /**
     * Set the state of the user
     * 
     * @param username The username
     * @param state    The state
     */
    public void setState(String username, String state) {
        UserState userState = UserState.valueOf(state);
        userStateMap.put(username, userState);
    }

    /**
     * Get the state of the user
     * 
     * @param username The username
     * @return The state
     */
    public UserState getState(String username) {
        userStateMap.putIfAbsent(username, UserState.ONLINE);
        return userStateMap.get(username);
    }
}
