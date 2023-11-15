package com.starta.DUBROVAJAVASUSHIPROJECT.controller;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Restaurant;
import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.jpa.JpaRestaurant;
import com.starta.DUBROVAJAVASUSHIPROJECT.exception.exceptions.EmptyListException;
import com.starta.DUBROVAJAVASUSHIPROJECT.exception.exceptions.EntityValidationException;
import com.starta.DUBROVAJAVASUSHIPROJECT.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "/all")
    public List<Restaurant> getAll() {
        List<Restaurant> restaurants = restaurantService.getAll();
        if (restaurants.isEmpty()) {
            throw new EmptyListException("List of restaurants is empty!");
        }
        return restaurants;
    }

    @GetMapping(value = "/id/{id}")
    public Restaurant getById (@PathVariable int id){
        return restaurantService.getById(id);
    }

    @PostMapping(value = "/add")
    public Restaurant add (@Valid @RequestBody JpaRestaurant restaurant){
        try {
            restaurantService.add(restaurant);
            return restaurant;
        } catch (Exception e) {
            throw new EntityValidationException(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteById (@PathVariable int id){
        restaurantService.deleteById(id);
    }

    @DeleteMapping(value = "/deletename/{name}")
    public void deleteByName (@PathVariable String name){
        restaurantService.deleteByName(name);
    }

    @GetMapping(value = "/count")
    public int getCount () {
        return restaurantService.getCount();
    }

    @GetMapping(value = "/total/{id}")
    public double getTotalPriceById (@PathVariable int id){
        return restaurantService.getTotalPriceById(id);
    }

    @GetMapping(value = "/average/{id}")
    public double getAveragePriceById (@PathVariable int id){
        return restaurantService.getAveragePriceById(id);
    }

    @PostMapping(value = "/addtomenu/{restaurantId}/{foodId}")
    public void addToMenuById (@PathVariable int restaurantId, @PathVariable int foodId){
        restaurantService.addToMenuById(restaurantId, foodId);
    }

    @DeleteMapping(value = "/deletefrommenu/{restaurantId}/{foodId}")
    public void deleteFromMenu (@PathVariable int restaurantId, @PathVariable int foodId){
        restaurantService.deleteFromMenu(restaurantId, foodId);
    }
    @DeleteMapping(value = "/clearmenu/{id}")
    public void clearMenu (@PathVariable int id){
        restaurantService.clearMenu(id);
    }
}
