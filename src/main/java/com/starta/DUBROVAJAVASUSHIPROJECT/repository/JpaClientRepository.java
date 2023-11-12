package com.starta.DUBROVAJAVASUSHIPROJECT.repository;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.jpa.JpaClient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaClientRepository extends JpaRepository<JpaClient, Integer> {

    @Transactional
    void deleteByName(String name);
}
