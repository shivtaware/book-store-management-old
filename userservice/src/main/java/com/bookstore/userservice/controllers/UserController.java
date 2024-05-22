package com.bookstore.userservice.controllers;

import com.bookstore.userservice.model.User;
import com.bookstore.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        return userService.register(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PostMapping("/login")
    public String login(@RequestParam String userName, @RequestParam String password){
        return userService.login(userName,password);
    }

}
