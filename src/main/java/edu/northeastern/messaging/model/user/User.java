package edu.northeastern.messaging.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * User Entity
 */
@AllArgsConstructor
@Getter
@Setter
public class User {
    private String username;

    private UserState userState;
}
