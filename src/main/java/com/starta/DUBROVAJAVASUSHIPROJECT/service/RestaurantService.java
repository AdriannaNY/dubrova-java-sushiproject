package com.starta.DUBROVAJAVASUSHIPROJECT.service;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAll();
    Restaurant getById(int id);
    Restaurant getByCity(String city);
    Restaurant getByName(String name);
    void add(Restaurant restaurant);
    void update(int restaurantId, Restaurant restaurant);
    void deleteById(int id);
    void deleteByName(String name);
    int getCount();
    double getTotalPriceById(int id);
    double getAveragePriceById(int id);
    void addToMenuById(int restaurantId, int foodId);
    void deleteFromMenu(int restaurantId, int foodId);
    void clearMenu(int restaurantId);
}
