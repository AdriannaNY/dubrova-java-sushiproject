package com.starta.DUBROVAJAVASUSHIPROJECT.repository;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.jpa.JpaCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCartRepository extends JpaRepository<JpaCart, Integer> {
}
