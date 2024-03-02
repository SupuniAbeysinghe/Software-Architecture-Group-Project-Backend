package com.eCommerceWeb.eCommerceWeb.service;

import com.eCommerceWeb.eCommerceWeb.dto.RegistrationDTO;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public String register(RegistrationDTO registerDTO) {
        return "works";
    }
}
