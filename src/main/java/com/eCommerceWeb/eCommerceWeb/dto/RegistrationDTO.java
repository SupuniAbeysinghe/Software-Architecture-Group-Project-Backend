package com.eCommerceWeb.eCommerceWeb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class RegistrationDTO {
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String password;
}
