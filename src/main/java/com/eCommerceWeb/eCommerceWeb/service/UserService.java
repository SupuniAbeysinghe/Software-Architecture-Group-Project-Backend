package com.eCommerceWeb.eCommerceWeb.service;

import com.eCommerceWeb.eCommerceWeb.dto.LoginDTO;
import com.eCommerceWeb.eCommerceWeb.dto.UserDTO;
import com.eCommerceWeb.eCommerceWeb.response.LoginResponse;

public interface UserService {

    void addUser(UserDTO userDTO);

    LoginResponse loginUser(LoginDTO loginDTO);
}
