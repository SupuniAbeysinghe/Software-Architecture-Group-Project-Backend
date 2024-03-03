package com.eCommerceWeb.eCommerceWeb.controller;

import com.eCommerceWeb.eCommerceWeb.dto.AuthenticationDTO;
import com.eCommerceWeb.eCommerceWeb.dto.RegisterDTO;
import com.eCommerceWeb.eCommerceWeb.exception.InvalidTokenException;
import com.eCommerceWeb.eCommerceWeb.response.AuthenticationResponse;
import com.eCommerceWeb.eCommerceWeb.service.AuthenticationService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterDTO request) throws MessagingException {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationDTO request){
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/confirm-email")
    public ResponseEntity<?> confirmEmail(@RequestParam("token") String token) throws InvalidTokenException {
        try{
            if(service.verifyUser(token)){
                return ResponseEntity.ok("Your email has been successfully verified.");
            }else{
                return  ResponseEntity.ok("Link expired or token already verified.");
            }
        }catch (InvalidTokenException e){
            return ResponseEntity.ok("Link expired or token already verified.");
        }
    }
}
