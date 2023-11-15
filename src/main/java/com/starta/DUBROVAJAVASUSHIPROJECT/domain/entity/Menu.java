package com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity;

import java.util.List;

public interface Menu {

    double getTotalPrice();
    List<Food> getAllFoods();
    void addFood(Food food);
    void removeFood(Food food);
    void clear();
}
