package com.starta.DUBROVAJAVASUSHIPROJECT.repository;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.jpa.JpaRestaurant;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRestaurantRepository extends JpaRepository<JpaRestaurant, Integer> {

    @Transactional
    void deleteByName(String name);
}
