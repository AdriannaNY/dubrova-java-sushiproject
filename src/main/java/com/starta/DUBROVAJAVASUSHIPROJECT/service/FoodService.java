package com.starta.DUBROVAJAVASUSHIPROJECT.service;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Client;
import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Food;

import java.util.List;

public interface FoodService {

    List<Food> getAll();
    Food getById(int id);
    Food getByName(String name);
    void add(Food food);
    void deleteById(int id);
    void deleteByName(String name);
    int getCount();
    double getTotalPrice();
    double getAveragePrice();
}
