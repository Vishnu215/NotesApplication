package com.notes.application.Notes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.notes.application.Notes.exceptions.AuthenticationException;
import com.notes.application.Notes.models.User;
import com.notes.application.Notes.repository.UserRepository;

@Service
public class UserService {


    UserRepository userRepository;

    @Autowired
    public UserService(@Qualifier("userRepo") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User loginUser(String email, String password) throws AuthenticationException {
        Optional<User> opt = userRepository.findByEmail(email);
        if (!opt.isPresent()) {
            throw new AuthenticationException("User does not exits");
        }
        if (!opt.get().getPassword().equals(password))
            throw new AuthenticationException("Incorrect password");
        return opt.get();
    }

    public User RegisterUser(User user) throws AuthenticationException {
        if (userRepository.exists(Example.of(user))) {
            throw new AuthenticationException("user already exits");
        }
        return userRepository.save(user);
    }
}