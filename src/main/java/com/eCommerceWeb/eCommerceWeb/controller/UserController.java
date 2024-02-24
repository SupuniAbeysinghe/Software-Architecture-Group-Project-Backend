package com.eCommerceWeb.eCommerceWeb.controller;

import com.eCommerceWeb.eCommerceWeb.dto.UserDTO;
import com.eCommerceWeb.eCommerceWeb.entity.User;
import com.eCommerceWeb.eCommerceWeb.repository.UserRepository;
import com.eCommerceWeb.eCommerceWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam int id){
        return userRepository.findById(id);
    }

    @PostMapping("/user")
    public void addUser(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
    }
}
