package com.starta.DUBROVAJAVASUSHIPROJECT.service.jpa;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Cart;
import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Client;
import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Food;
import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.jpa.JpaCart;
import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.jpa.JpaClient;
import com.starta.DUBROVAJAVASUSHIPROJECT.repository.JpaCartRepository;
import com.starta.DUBROVAJAVASUSHIPROJECT.repository.JpaClientRepository;
import com.starta.DUBROVAJAVASUSHIPROJECT.repository.JpaFoodRepository;
import com.starta.DUBROVAJAVASUSHIPROJECT.service.ClientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaClientService implements ClientService {

    @Autowired
    private JpaClientRepository clientRepository;

    @Autowired
    private JpaCartRepository cartRepository;

    @Autowired
    private JpaFoodRepository foodRepository;


    @Override
    public List<Client> getAll() {
        return new ArrayList<>(clientRepository.findAll());
    }

    @Override
    public Client getById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client getByName(String name) {
        return clientRepository.findByName(name);
    }

    @Override
    public void add(Client client) {
        JpaClient savedClient = clientRepository.save(new JpaClient(0, client.getName(),
                client.getAge(), client.getAddress(), client.getPhone(), client.getEmail()));
        cartRepository.save(new JpaCart(savedClient));
    }

    @Override
    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        clientRepository.deleteByName(name);
    }

    @Override
    public int getCount() {
        return (int) clientRepository.count();
    }

    @Override
    public double getTotalPriceById(int id) {
        return getById(id).getCart().getTotalPrice();
    }

    @Override
    public double getAveragePriceById(int id) {
        Cart cart = getById(id).getCart();
        return cart.getTotalPrice() / cart.getAllFoods().size();
    }

    @Transactional
    @Override
    public void addToCartById(int clientId, int foodId) {
        Client client = clientRepository.findById(clientId).orElse(null);
        Food food = foodRepository.findById(foodId).orElse(null);
        Cart cart = client.getCart();
        cart.addFood(food);
    }

    @Transactional
    @Override
    public void deleteFromCart(int clientId, int foodId) {
        getById(clientId).getCart().removeFood(foodRepository.findById(foodId).orElse(null));
    }

    @Transactional
    @Override
    public void clearCart(int clientId) {
        getById(clientId).getCart().clear();
    }
}
