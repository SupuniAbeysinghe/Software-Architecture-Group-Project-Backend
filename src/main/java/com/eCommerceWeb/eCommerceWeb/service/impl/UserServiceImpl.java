package com.eCommerceWeb.eCommerceWeb.service.impl;

import com.eCommerceWeb.eCommerceWeb.dto.LoginDTO;
import com.eCommerceWeb.eCommerceWeb.repository.UserRepository;
import com.eCommerceWeb.eCommerceWeb.response.LoginResponse;
import com.eCommerceWeb.eCommerceWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
//    @Override
//    public void addUser(UserDTO userDTO) {
//
//        User user = new User(
//                userDTO.getId(),
//                userDTO.getEmail(),
//                userDTO.getFirstName(),
//                userDTO.getLastName(),
//                userDTO.getAddress(),
//                this.passwordEncoder.encode(userDTO.getPassword())
//        );
//
//        userRepository.save(user);
//
//    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        return null;
    }

//    @Override
//    public LoginResponse loginUser(LoginDTO loginDTO) {
//        String msg = "";
//        User user1 = userRepository.findByEmail(loginDTO.getEmail());
//
//        if( user1 != null){
//            String password = loginDTO.getPassword();
//            String encodedPassword = user1.getPassword();
//            Boolean isPwdRight = passwordEncoder.matches(password,encodedPassword);
//
//
//            if(isPwdRight){
//                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
//                if(user.isPresent()){
//                    return new LoginResponse("Login Success",true);
//                }else{
//                    return new LoginResponse("Login Failed",false);
//                }
//            }else{
//                return new LoginResponse("Password does not match",false);
//            }
//        }else{
//            return new LoginResponse("Email does not exist",false);
//        }
//    }
}
