package com.eCommerceWeb.eCommerceWeb.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwsAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http.csrf().disable();
//        http.cors().disable();
//        http.authorizeHttpRequests(request -> {
//            request.requestMatchers("/api/v1/auth/**").permitAll();
//        });
//        http.addFilterBefore(jwsAuthFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();

        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/vi/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwsAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }





}
