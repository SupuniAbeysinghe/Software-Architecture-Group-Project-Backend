package com.eCommerceWeb.eCommerceWeb.service;

import com.eCommerceWeb.eCommerceWeb.dto.LoginDTO;
import com.eCommerceWeb.eCommerceWeb.entity.User;
import com.eCommerceWeb.eCommerceWeb.response.LoginResponse;

import java.util.Optional;

public interface UserService {

   // void addUser(UserDTO userDTO);

    LoginResponse loginUser(LoginDTO loginDTO);
    public Optional<User> getUser(String username);

    //void sendRegistrationConfirmationEmail(final User user) throws MessagingException;
    //boolean verifyUser(final String token) throws InvalidTokenException;
}
