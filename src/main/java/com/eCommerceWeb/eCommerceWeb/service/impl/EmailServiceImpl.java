package com.eCommerceWeb.eCommerceWeb.service.impl;

import com.eCommerceWeb.eCommerceWeb.entity.EmailConfirmationToken;
import com.eCommerceWeb.eCommerceWeb.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender sender;

    public EmailServiceImpl(JavaMailSender sender) {
        this.sender = sender;
    }

    @Override
    public void sendConfirmationEmail(EmailConfirmationToken emailConfirmationToken) throws MessagingException {
        //MIME - HTML message
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setTo(emailConfirmationToken.getUser().getUsername());
        helper.setSubject("Confirm your E-mail Address - The Bookshelf");
        helper.setText("<html>"+
                "<body>"+
                "<h2>Dear "+emailConfirmationToken.getUser().getFirstName() + ", </h2>"+
                "<br/>We are excited to have you get started. Please click on below link to confirm your account."+
                "<br/>"+ generateConfirmationLink(emailConfirmationToken.getToken())+""+
                "<br/>Regards,<br?>"+
                "The Bookshelf team"+
                "</body>"+
                "</html>"
                ,true);
        sender.send(message);
    }

    private String generateConfirmationLink(String token){
        return "<a href=http://localhost:8080/confirm-email?token="+token+">Confirm Email</a>";
    }
}
