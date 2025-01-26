package com.usermanagementsystem.usermanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagementsystem.usermanagementsystem.exception.UserNotFoundException;
import com.usermanagementsystem.usermanagementsystem.model.User;
import com.usermanagementsystem.usermanagementsystem.repository.UserRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin("http://localhost:3000")

public class UserController {
    @Autowired
    private UserRepository userRepository;

// admin=user (path)
    @PostMapping("/admin")
    User newUser(@RequestBody User newUser) {
        
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }


    // Get user with specific id
    @GetMapping("/admin/{id}")
    User getUserBId(@PathVariable Long id){
        return userRepository.findById(id)
        .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/admin/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(admin -> {
                    admin.setUsername(newUser.getUsername());
                    admin.setName(newUser.getName());
                    admin.setEmail(newUser.getEmail());
                    return userRepository.save(admin);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    


}
