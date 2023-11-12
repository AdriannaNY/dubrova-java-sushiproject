package com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity;

import java.util.List;

public interface Cart {

    double getTotalPrice();
    List<Food> getAllFoods();
    void addFood(Food food);
    void removeFood(Food food);
    void clear();
}
