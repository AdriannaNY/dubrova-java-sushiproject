package com.starta.DUBROVAJAVASUSHIPROJECT.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CypherPassword {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("admin"));
        System.out.println(encoder.encode("user"));
    }
}
