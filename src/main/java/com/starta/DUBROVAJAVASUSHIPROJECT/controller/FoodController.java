package com.starta.DUBROVAJAVASUSHIPROJECT.controller;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Food;
import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.jpa.JpaFood;
import com.starta.DUBROVAJAVASUSHIPROJECT.exception.exceptions.EntityValidationException;
import com.starta.DUBROVAJAVASUSHIPROJECT.exception.exceptions.EmptyListException;
import com.starta.DUBROVAJAVASUSHIPROJECT.service.FoodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping(value = "/all")
    public List<Food> getAll() {
        List<Food> foods = foodService.getAll();
        if (foods.isEmpty()) {
            throw new EmptyListException("List of foods is empty!");
        }
        return foods;
    }

    @GetMapping(value = "/id/{id}")
    public Food getById(@PathVariable int id) {
        return foodService.getById(id);
    }

    @GetMapping(value = "/name/{name}")
    public Food getByName(@PathVariable String name) {
        return foodService.getByName(name);
    }

    @PostMapping(value = "/add")
    public Food add(@Valid @RequestBody JpaFood food) {
        try {
            foodService.add(food);
            return food;
        } catch (Exception e) {
            throw new EntityValidationException(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable int id) {
        foodService.deleteById(id);
    }

    @DeleteMapping(value = "/deletename/{name}")
    public void deleteByName(@PathVariable String name) {
        foodService.deleteByName(name);
    }

    @GetMapping(value = "/count")
    public int getCount() {
        return foodService.getCount();
    }

    @GetMapping(value = "/total")
    public double getTotalPrice() {
        return foodService.getTotalPrice();
    }

    @GetMapping(value = "/average")
    public double getByAveragePrice() {
        return foodService.getAveragePrice();
    }

}
