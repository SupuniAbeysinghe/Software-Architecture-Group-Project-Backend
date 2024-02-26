package com.eCommerceWeb.eCommerceWeb.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginResponse  {
    String message;
    Boolean status;
}
