package com.example.Splimate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http)
            throws Exception {

    	http
        .cors(cors -> {})
        .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                .requestMatchers(
                        "/users/register",
                        "/users/login",
                        "/groups/create",
                        "/groups/mygroups",
                        "/members/add",
                        "/members/getgroupmembers",
                        "/expense/groups",
                        "/settlementcalculate",
                        "/groups/count",
                        "/expense/total",
                        "/expense/delete",
                        "/expense/delete",
                        "/members/delete",
                        "/expense/add",
                        "/groups/delete"
        
                        )
                .permitAll()
 
                .anyRequest()
                .authenticated())

            .addFilterBefore(
                    jwtFilter,
                    UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration =
                new CorsConfiguration();

        configuration.setAllowedOriginPatterns(
                List.of("*"));

        configuration.setAllowedMethods(
                List.of("*"));

        configuration.setAllowedHeaders(
                List.of("*"));

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration(
                "/**",
                configuration);

        return source;
    }
}