package com.eCommerceWeb.eCommerceWeb.controller;

import com.eCommerceWeb.eCommerceWeb.dto.RegistrationDTO;
import com.eCommerceWeb.eCommerceWeb.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/register")
public class RegistrationController {

    private RegistrationService registrationService;

    public String register(@RequestBody RegistrationDTO registerDTO){
        return registrationService.register(registerDTO);
    }
}
