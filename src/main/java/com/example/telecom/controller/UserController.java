package com.example.telecom.controller;

import com.example.telecom.model.User_Block.User;
import com.example.telecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("users")
    public List<User> showAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("users/{name}")
    @ResponseStatus(HttpStatus.OK)
    public User findByName(@PathVariable String name){
        return userRepository.findUserByName(name);
    }

    @GetMapping("users-number")
    @ResponseStatus(HttpStatus.OK)
    public User findUserByNumber(@RequestParam String number){
        return userRepository.findUserByPhoneNumber(number);
    }
}
