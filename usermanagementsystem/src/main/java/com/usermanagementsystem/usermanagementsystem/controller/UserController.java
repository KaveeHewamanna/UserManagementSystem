package com.usermanagementsystem.usermanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagementsystem.usermanagementsystem.model.User;
import com.usermanagementsystem.usermanagementsystem.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    
// admin=user (path)
    @PostMapping("/admin")
    User newUser(@RequestBody User newUser) {
        
        return userRepository.save(newUser);
    }
    

    


}
