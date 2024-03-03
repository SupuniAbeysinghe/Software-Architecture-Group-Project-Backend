package com.eCommerceWeb.eCommerceWeb.service;

import com.eCommerceWeb.eCommerceWeb.dto.AuthenticationDTO;
import com.eCommerceWeb.eCommerceWeb.dto.RegisterDTO;
import com.eCommerceWeb.eCommerceWeb.entity.Role;
import com.eCommerceWeb.eCommerceWeb.entity.User;
import com.eCommerceWeb.eCommerceWeb.repository.UserRepository;
import com.eCommerceWeb.eCommerceWeb.response.AuthenticationResponse;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

//    private final EmailService emailService;
//    private final EmailConfirmationTokenRepository emailConfirmationTokenRepository;
//    private final BytesKeyGenerator DEFAULT_TOKEN_GENERATOR = KeyGenerators.secureRandom(15);
//    private final Charset US_ASCII = Charset.forName("US-ASCII");


    public AuthenticationResponse register(@NotNull RegisterDTO request) throws MessagingException {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        //sendRegistrationConfirmationEmail(user);

        var jwtToken =jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword())
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken =jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
//    public void sendRegistrationConfirmationEmail(User user) throws MessagingException {
//
//        // Generate the key
//        byte[] key = DEFAULT_TOKEN_GENERATOR.generateKey();
//
//        // Perform URL-safe Base64 encoding using Apache Commons Codec
//        String base64Str = Base64.encodeBase64URLSafeString(key);
//
//        // Create and populate EmailConfirmationToken
//        EmailConfirmationToken emailConfirmationToken = new EmailConfirmationToken();
//        emailConfirmationToken.setToken(base64Str);
//        emailConfirmationToken.setTimeStamp(LocalDateTime.now());
//        emailConfirmationToken.setUser(user);
//        emailConfirmationTokenRepository.save(emailConfirmationToken);
//
//        // Send confirmation email
//        emailService.sendConfirmationEmail(emailConfirmationToken);
//    }


//    public void sendRegistrationConfirmationEmail(User user) throws MessagingException {
//        String tokenValue = new String(Base64.encodeBase64URLSafe(DEFAULT_TOKEN_GENERATOR.generateKey()),US_ASCII);
//        EmailConfirmationToken emailConfirmationToken = new EmailConfirmationToken();
//        emailConfirmationToken.setToken(tokenValue);
//        emailConfirmationToken.setTimeStamp(LocalDateTime.now());
//        emailConfirmationToken.setUser(user);
//        emailConfirmationTokenRepository.save(emailConfirmationToken);
//
//        //send email
//        emailService.sendConfirmationEmail(emailConfirmationToken);
//    }

//    public boolean verifyUser(String token) throws InvalidTokenException {
//        EmailConfirmationToken emailConfirmationToken = emailConfirmationTokenRepository.findByToken(token);
//        if(Objects.isNull(emailConfirmationToken) || !token.equals(emailConfirmationToken.getToken())){
//            throw new InvalidTokenException("Token is not valid");
//        }
//        User user = emailConfirmationToken.getUser();
//        if (Objects.isNull(user)){
//            return false;
//        }
//        user.setAccountVerified(true);
//        repository.save(user);
//        emailConfirmationTokenRepository.delete(emailConfirmationToken);
//        return true;
//
//    }

}
 