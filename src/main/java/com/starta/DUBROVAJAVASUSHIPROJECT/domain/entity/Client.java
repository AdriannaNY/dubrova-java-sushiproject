package com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity;

public interface Client {

    int getId();
    String getName();
    int getAge();
    String getAddress();
    String getPhone();
    String getEmail();
    Cart getCart();
}
