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
    private UserService userService;

    @GetMapping(value = "/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping(value = "/username/{username}")
    public UserDetails getByName(@PathVariable String username) {
        return userService.loadUserByUsername(username);
    }

    @PostMapping(value = "/add")
    public User add(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
