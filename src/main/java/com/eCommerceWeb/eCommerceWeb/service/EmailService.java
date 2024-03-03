package com.eCommerceWeb.eCommerceWeb.service;

import com.eCommerceWeb.eCommerceWeb.entity.EmailConfirmationToken;
import jakarta.mail.MessagingException;

public interface EmailService {
    void sendConfirmationEmail(EmailConfirmationToken emailConfirmationToken) throws MessagingException;
}
