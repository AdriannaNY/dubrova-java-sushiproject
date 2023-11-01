package com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RestaurantFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "food_id")
    private int foodId;

    @Column(name = "restaurant_id")
    private int restaurantId;
}
