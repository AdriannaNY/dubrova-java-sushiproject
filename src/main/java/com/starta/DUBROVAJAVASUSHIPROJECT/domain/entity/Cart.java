package com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "food_id")
    private int foodId;

    @Column(name = "quantity")
    private int quantity;
}
