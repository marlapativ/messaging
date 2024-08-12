package edu.northeastern.messaging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.messaging.model.user.User;
import edu.northeastern.messaging.service.user.UserFacade;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @PostMapping("{username}/state/{state}")
    public User register(@PathVariable String username, @PathVariable String state) {
        userFacade.updateUser(username, state);
        return userFacade.getUser(username);
    }

    @GetMapping("{username}")
    public User get(@PathVariable String username) {
        return userFacade.getUser(username);
    }
}
