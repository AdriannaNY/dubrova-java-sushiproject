package com.starta.DUBROVAJAVASUSHIPROJECT.repository;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.jpa.JpaFood;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaFoodRepository extends JpaRepository<JpaFood, Integer> {

    @Transactional
    void deleteByName(String name);

    @Query(value = "SELECT SUM(price) FROM food;", nativeQuery = true)
    double getTotalPrice();

    @Query(value = "SELECT AVG(price) FROM food;", nativeQuery = true)
    double getAveragePrice();
}
