package com.starta.DUBROVAJAVASUSHIPROJECT.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(x -> x
                        .requestMatchers(HttpMethod.GET,
                                "/food/all",
                                "/restaurant/all").permitAll()

                        .requestMatchers(HttpMethod.GET,
                                "/user/all",
                                "/user/username",

                                "/food/id",

                                "/client/add/clientId/foodId",
                                "/client/delete/clientId/foodId",
                                "/client/clear/id",

                                "/restaurant/id").hasAnyRole("USER", "ADMIN")

                        .requestMatchers(HttpMethod.GET,
                                "/client/all",
                                "/client/id",
                                "/client/count",
                                "/client/total/id",
                                "/client/average/id",

                                "/food/count",
                                "/food/total",
                                "/food/average",

                                "/restaurant/count",
                                "/restaurant/total/id",
                                "/restaurant/average/id").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST,
                                "/user/add",
                                "/client/add",
                                "/food/add",
                                "/restaurant/add").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.DELETE,
                                "/client/delete/id",
                                "/client/deletename/name",

                                "/food/delete/id",
                                "/food/deletename/name",

                                "/restaurant/delete/id",
                                "/restaurant/deletename/name",
                                "/restaurant/delete/restaurantId/foodId").hasRole("ADMIN")

                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

}
