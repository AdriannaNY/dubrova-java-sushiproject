package com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.print.attribute.standard.DateTimeAtCreation;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "order_id_number")
    private String orderIdNumber;

    @Column(name = "food_id")
    private int foodId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "delivery_date")
    private String deliveryDate;

    @Column(name = "delivery_status")
    private String deliveryStatus;
}
