package edu.northeastern.messaging.service.user;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import edu.northeastern.messaging.model.user.UserState;

@Component
public class UserStateService {

    private HashMap<String, UserState> userStateMap;

    public UserStateService() {
        userStateMap = new HashMap<>();
    }

    public void setState(String username, String state) {
        UserState userState = UserState.valueOf(state);
        userStateMap.put(username, userState);
    }

    public UserState getState(String username) {
        userStateMap.putIfAbsent(username, UserState.ONLINE);
        return userStateMap.get(username);
    }
}
