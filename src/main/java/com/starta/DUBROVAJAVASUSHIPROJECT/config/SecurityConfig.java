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
                                "/food/name",
                                "/food/count",
                                "/food/total",
                                "/food/average",

                                "/client/all",
                                "/client/id",
                                "/client/name",
                                "/client/count",
                                "/client/total",
                                "/client/average",

                                "/restaurant/id",
                                "/restaurant/city",
                                "/restaurant/name",
                                "/restaurant/count",
                                "/restaurant/total",
                                "/restaurant/average").hasAnyRole("USER", "ADMIN")

                        .requestMatchers(HttpMethod.POST,
                                "/user/add",

                                "/client/add",
                                "/client/addtocart",

                                "/food/add",

                                "/restaurant/add",
                                "/restaurant/addtomenu").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.DELETE,
                                "/client/delete",
                                "/client/deletename",
                                "/client/deletefromcart",
                                "/client/clearcart",

                                "/food/delete",
                                "/food/deletename",

                                "/restaurant/delete",
                                "/restaurant/deletename",
                                "/restaurant/deletefrommenu",
                                "/restaurant/clearmenu").hasRole("ADMIN")

                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

}
