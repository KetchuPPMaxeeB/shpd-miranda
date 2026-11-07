package com.miranda.shpd.security;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public JwtAuthenticationConverter authenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(new RoleConverter());
        return converter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET,
                                         "/api/tariffs", "/api/tariffs/**",
                                         "/api/bonuses", "/api/bonuses/**",
                                         "/api/promotions", "/api/promotions/**",
                                         "/api/services", "/api/services/**").permitAll()
                        .requestMatchers(HttpMethod.POST,
                                         "/api/tariffs", "/api/tariffs/**",
                                         "/api/bonuses", "/api/bonuses/**",
                                         "/api/promotions", "/api/promotions/**",
                                         "/api/services", "/api/services/**").hasRole("CATALOG_ADMIN")
                        .requestMatchers(HttpMethod.PUT,
                                         "/api/tariffs", "/api/tariffs/**",
                                         "/api/bonuses", "/api/bonuses/**",
                                         "/api/promotions", "/api/promotions/**",
                                         "/api/services", "/api/services/**").hasRole("CATALOG_ADMIN")
                        .requestMatchers(HttpMethod.PATCH,
                                         "/api/tariffs", "/api/tariffs/**",
                                         "/api/bonuses", "/api/bonuses/**",
                                         "/api/promotions", "/api/promotions/**",
                                         "/api/services", "/api/services/**").hasRole("CATALOG_ADMIN")
                        .requestMatchers(HttpMethod.DELETE,
                                         "/api/tariffs", "/api/tariffs/**",
                                         "/api/bonuses", "/api/bonuses/**",
                                         "/api/promotions", "/api/promotions/**",
                                         "/api/services", "/api/services/**").hasRole("CATALOG_ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/auth-check").hasRole("CATALOG_ADMIN")
                        .dispatcherTypeMatchers(DispatcherType.ERROR).permitAll()

                        .anyRequest().denyAll())
                .sessionManagement(session -> session.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(oauth -> oauth
                        .jwt(jwt -> jwt.jwtAuthenticationConverter(authenticationConverter()))
                );
        return http.build();
    }

}
