package com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
