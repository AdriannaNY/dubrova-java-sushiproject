package com.starta.DUBROVAJAVASUSHIPROJECT.service;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAll();
    Client getById(int id);
    void add(Client client);
    void deleteById(int id);
    void deleteByName(String name);
    int getCount();
    double getTotalPriceById(int id);
    double getAveragePriceById(int id);
    void addToCartById(int clientId, int foodId);
    void deleteFromCart(int clientId, int foodId);
    void clearCart(int clientId);
}
