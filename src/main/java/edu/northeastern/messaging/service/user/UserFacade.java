package edu.northeastern.messaging.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.messaging.model.user.User;

@Component
public class UserFacade {

    @Autowired
    private UserStateService userStateService;

    @Autowired
    private UserInfoService userInfoService;

    public User getUser(String username) {
        User user = userInfoService.getUserInfo(username);
        user.setUserState(userStateService.getState(username));
        return user;
    }

    public void updateUser(String username, String state) {
        userStateService.setState(username, state);
    }

}
