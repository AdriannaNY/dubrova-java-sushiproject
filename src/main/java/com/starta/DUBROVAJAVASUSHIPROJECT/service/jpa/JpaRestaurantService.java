package com.starta.DUBROVAJAVASUSHIPROJECT.service.jpa;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Food;
import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Menu;
import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Restaurant;
import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.jpa.JpaMenu;
import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.jpa.JpaRestaurant;
import com.starta.DUBROVAJAVASUSHIPROJECT.repository.JpaFoodRepository;
import com.starta.DUBROVAJAVASUSHIPROJECT.repository.JpaMenuRepository;
import com.starta.DUBROVAJAVASUSHIPROJECT.repository.JpaRestaurantRepository;
import com.starta.DUBROVAJAVASUSHIPROJECT.service.RestaurantService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaRestaurantService implements RestaurantService {

    @Autowired
    private JpaRestaurantRepository restaurantRepository;

    @Autowired
    private JpaMenuRepository menuRepository;

    @Autowired
    private JpaFoodRepository foodRepository;


    @Override
    public List<Restaurant> getAll() {
        return new ArrayList<>(restaurantRepository.findAll());
    }

    @Override
    public Restaurant getById(int id) {
        return restaurantRepository.findById(id).orElse(null);
    }
    public Restaurant getByCity(String city) {
        return restaurantRepository.findByCity(city);
    }

    public Restaurant getByName(String name) {
        return restaurantRepository.findByName(name);
    }

    @Override
    public void add(Restaurant restaurant) {
        JpaRestaurant savedRestaurant = restaurantRepository.save(new JpaRestaurant(0, restaurant.getName(),
                restaurant.getCity(), restaurant.getAddress(), restaurant.getPhone(), restaurant.getEmail()));
        menuRepository.save(new JpaMenu(savedRestaurant));
    }

    @Override
    public void deleteById(int id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        restaurantRepository.deleteByName(name);
    }

    @Override
    public int getCount() {
        return (int) restaurantRepository.count();
    }

    @Override
    public double getTotalPriceById(int id) {
        return getById(id).getMenu().getTotalPrice();
    }

    @Override
    public double getAveragePriceById(int id) {
        Menu menu = getById(id).getMenu();
        return menu.getTotalPrice() / menu.getAllFoods().size();
    }

    @Transactional
    @Override
    public void addToMenuById(int restaurantId, int foodId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        Food food = foodRepository.findById(foodId).orElse(null);
        Menu menu = restaurant.getMenu();
        menu.addFood(food);
    }

    @Transactional
    @Override
    public void deleteFromMenu(int restaurantId, int foodId) {
        getById(restaurantId).getMenu().removeFood(foodRepository.findById(foodId).orElse(null));
    }

    @Transactional
    @Override
    public void clearMenu(int restaurantId) {
        getById(restaurantId).getMenu().clear();
    }

}
