package com.eCommerceWeb.eCommerceWeb.controller;

import com.eCommerceWeb.eCommerceWeb.entity.User;
import com.eCommerceWeb.eCommerceWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class UserController {
    UserRepository userRepository;
    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam int id){
        return userRepository.findById(id);
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        userRepository.save(user);
    }
}
