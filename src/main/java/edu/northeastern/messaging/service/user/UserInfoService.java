package edu.northeastern.messaging.service.user;

import org.springframework.stereotype.Component;

import edu.northeastern.messaging.model.user.User;
import edu.northeastern.messaging.model.user.UserState;

@Component
public class UserInfoService {

    public User getUserInfo(String username) {
        return new User(username, UserState.ONLINE);
    }

}
