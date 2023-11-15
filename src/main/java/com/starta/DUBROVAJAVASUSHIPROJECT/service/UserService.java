package com.starta.DUBROVAJAVASUSHIPROJECT.service;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Role;
import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.User;
import com.starta.DUBROVAJAVASUSHIPROJECT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;   // must add to bean -> config package

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        return user;
    }

    public User saveUser(User user) {
        User foundUser = repository.findByUsername(user.getUsername());

        if (foundUser != null) {   // if user already exist - stop and return null
            return null;
        }

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(2, "ROLE_USER"));
        user.setRoles(roles);

        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return repository.save(user);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

}
