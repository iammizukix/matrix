package com.analyze.matrix.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests((requests) -> requests
                                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                                                .permitAll()
                                                .requestMatchers("/", "/registration/**").permitAll()
                                                // .requestMatchers("/").hasRole("ROLE_USER")
                                                .anyRequest().authenticated())
                                .formLogin((form) -> form
                                                .loginProcessingUrl("/login")
                                                .loginPage("/login")
                                                .defaultSuccessUrl("/index", true)
                                                .failureUrl("/login?error")
                                                .permitAll())
                                .logout((logout) -> logout
                                                .logoutSuccessUrl("/login"));
                return http.build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }
}