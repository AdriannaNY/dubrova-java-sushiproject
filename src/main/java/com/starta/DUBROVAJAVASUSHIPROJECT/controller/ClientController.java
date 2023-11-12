package com.starta.DUBROVAJAVASUSHIPROJECT.controller;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Client;
import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.jpa.JpaClient;
import com.starta.DUBROVAJAVASUSHIPROJECT.exception.exceptions.EntityValidationException;
import com.starta.DUBROVAJAVASUSHIPROJECT.exception.exceptions.ThirdTestException;
import com.starta.DUBROVAJAVASUSHIPROJECT.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/all")
    public List<Client> getAll() {
        List<Client> clients = clientService.getAll();
        if (clients.isEmpty()) {
            throw new ThirdTestException("List of clients is empty!");
        }
        return clients;
    }

    @GetMapping(value = "/{id}")
    public Client getById (@PathVariable int id){
        return clientService.getById(id);
    }

    @PostMapping(value = "/add")
    public Client add (@Valid @RequestBody JpaClient client){
        try {
            clientService.add(client);
            return client;
        } catch (Exception e) {
            throw new EntityValidationException(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteById (@PathVariable int id){
        clientService.deleteById(id);
    }

    @DeleteMapping(value = "/deletename/{name}")
    public void deleteByName (@PathVariable String name){
        clientService.deleteByName(name);
    }

    @GetMapping(value = "/count")
    public int getCount () {
        return clientService.getCount();
    }

    @GetMapping(value = "/total/{id}")
    public double getTotalPriceById (@PathVariable int id){
        return clientService.getTotalPriceById(id);
    }

    @GetMapping(value = "/average/{id}")
    public double getAveragePriceById (@PathVariable int id){
        return clientService.getAveragePriceById(id);
    }

    @GetMapping(value = "/add/{clientId}/{foodId}")
    public void addToCartById (@PathVariable int clientId, @PathVariable int foodId){
        clientService.addToCartById(clientId, foodId);
    }

    @DeleteMapping(value = "/delete/{clientId}/{foodId}")
    public void deleteFromCart (@PathVariable int clientId, @PathVariable int foodId){
        clientService.deleteFromCart(clientId, foodId);
    }

    @GetMapping(value = "/clear/{id}")
    public void clearCart (@PathVariable int id){
        clientService.clearCart(id);
    }

}