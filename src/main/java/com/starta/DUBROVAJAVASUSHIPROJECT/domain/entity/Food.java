package com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "restaurant_id")
    private int restaurantId;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "image")
    private String image;
}
