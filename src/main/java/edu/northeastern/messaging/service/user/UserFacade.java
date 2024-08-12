package edu.northeastern.messaging.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.messaging.model.user.User;

/**
 * Facade for handling user related operations
 */
@Component
public class UserFacade {

    @Autowired
    private UserStateService userStateService;

    @Autowired
    private UserInfoService userInfoService;

    /**
     * Get the user
     * 
     * @param username The username
     * @return The user
     */
    public User getUser(String username) {
        User user = userInfoService.getUserInfo(username);
        user.setUserState(userStateService.getState(username));
        return user;
    }

    /**
     * Update the user
     * 
     * @param username The username
     * @param state    The state
     */
    public void updateUser(String username, String state) {
        userStateService.setState(username, state);
    }

}
