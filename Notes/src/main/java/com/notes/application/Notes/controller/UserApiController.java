package com.notes.application.Notes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.notes.application.Notes.models.User;
import com.notes.application.Notes.service.UserService;

@RestController
@RequestMapping("/user")
public class UserApiController {


    UserService userService;

    @Autowired
    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public User loginUser(@RequestHeader(name = "api_key") String apiKey,@RequestParam("email") String email, @RequestParam("password") String password) {
        try {
            if (!apiKey.equals(apiKey))
            	throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            return userService.loginUser(email, password);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getLocalizedMessage(), exception);
        }
    }

    @PostMapping("/register")
    public User registerUser(@RequestHeader(name = "api_key") String apiKey, @RequestBody User user) {
        try {
            if (!apiKey.equals(apiKey))
            	throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            return userService.RegisterUser(user);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getLocalizedMessage(), exception);
        }
    }

}
