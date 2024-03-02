package com.eCommerceWeb.eCommerceWeb.controller;

import com.eCommerceWeb.eCommerceWeb.dto.RegisterDTO;
import com.eCommerceWeb.eCommerceWeb.entity.User;
import com.eCommerceWeb.eCommerceWeb.repository.UserRepository;
import com.eCommerceWeb.eCommerceWeb.response.AuthenticationResponse;
import com.eCommerceWeb.eCommerceWeb.service.AuthenticationService;
import com.eCommerceWeb.eCommerceWeb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;
    private UserRepository userRepository;
    private AuthenticationService service;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @GetMapping("/getUser")
    public User getUser(@RequestParam int id){
        return userRepository.findById(id);
    }

//    @PostMapping(path = "/save")
//    public void addUser(@RequestBody UserDTO userDTO){
//        userService.addUser(userDTO);
//    }

//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
//        LoginResponse loginResponse = userService.loginUser(loginDTO);
//        return ResponseEntity.ok(loginResponse);
//    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterDTO request){
        return ResponseEntity.ok(service.register(request));
    }




}
