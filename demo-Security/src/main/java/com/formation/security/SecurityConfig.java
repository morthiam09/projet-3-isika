package com.formation.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // indique à Spring que cette classe est une classe de configuration
@EnableWebSecurity // active la sécurité Web
public class SecurityConfig {

    @Bean // ici on configure les acces aux ressources (api)
    public SecurityFilterChain  filterChain(HttpSecurity http) throws Exception{
        http.csrf( csrf -> csrf.disable()) // désactive la protection CSRF
            .authorizeHttpRequests(
                authz -> authz
                        .requestMatchers(HttpMethod.GET, "/api/public/**").permitAll() // autorise les requêtes GET sur /api/public/**
                        .requestMatchers(HttpMethod.POST, "/api/auth/**").permitAll() 
                        .anyRequest().authenticated() // toutes les autres requêtes nécessitent une authentification
            ); // autorise toutes les requêtes

        http.httpBasic( Customizer.withDefaults() ); // active l'authentification HTTP de base

        return http.build();
    }

    @Bean
    public PasswordEncoder  passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
