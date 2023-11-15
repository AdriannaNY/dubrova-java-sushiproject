package com.starta.DUBROVAJAVASUSHIPROJECT.controller;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.User;
import com.starta.DUBROVAJAVASUSHIPROJECT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    // This method is available for all even for not authenticated users
    @GetMapping(value = "/all")
    public List<User> getAll() {
        return service.getAll();
    }

    // This method is available for authenticated users and admins
    @GetMapping(value = "/username/{username}")
    public UserDetails getByName(@PathVariable String username) {
        return service.loadUserByUsername(username);
    }

    // This method is available only for authenticated admins
    @PostMapping(value = "/add")
    public User add(@RequestBody User user) {
        return service.saveUser(user);
    }

}
