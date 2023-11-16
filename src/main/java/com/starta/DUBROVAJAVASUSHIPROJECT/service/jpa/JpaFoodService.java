package com.starta.DUBROVAJAVASUSHIPROJECT.service.jpa;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Food;
import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.jpa.JpaFood;
import com.starta.DUBROVAJAVASUSHIPROJECT.exception.exceptions.ResourceNotFoundException;
import com.starta.DUBROVAJAVASUSHIPROJECT.repository.JpaFoodRepository;
import com.starta.DUBROVAJAVASUSHIPROJECT.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaFoodService implements FoodService {

    @Autowired
    private JpaFoodRepository foodRepository;


    @Override
    public List<Food> getAll() {
        return new ArrayList<>(foodRepository.findAll());
    }

    @Override
    public Food getById(int id) {
        return foodRepository.findById(id).orElse(null);
    }

    @Override
    public Food getByName(String name) {
        return foodRepository.findByName(name);
    }

    @Override
    public void add(Food food) {
        foodRepository.save(new JpaFood(0, food.getName(), food.getDescription(), food.getPrice()));
    }

    @Override
    public void update(int foodId, Food food) {
        JpaFood updatedFood = foodRepository.findById(foodId)
                .orElseThrow(() -> new ResourceNotFoundException("Food is not exist with id: " + foodId));

        updatedFood.setName(food.getName());
        updatedFood.setDescription(food.getDescription());
        updatedFood.setPrice(food.getPrice());

        foodRepository.save(updatedFood);
    }

    @Override
    public void deleteById(int id) {
        foodRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        foodRepository.deleteByName(name);
    }

    @Override
    public int getCount() {
        return (int) foodRepository.count();
    }

    @Override
    public double getTotalPrice() {
        return foodRepository.getTotalPrice();
    }

    @Override
    public double getAveragePrice() {
        return foodRepository.getAveragePrice();
    }
}
