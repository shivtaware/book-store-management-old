package com.bookstore.userservice.service;

import com.bookstore.userservice.dao.UserRepository;
import com.bookstore.userservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
    public String register(User user) {
        try {
            repository.save(user);
            return "Success!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public User getUserById(int id) {
        return repository.findById(id).get();
    }

    public String login(String userName, String password) {
        User user = repository.findByUserName(userName);
        if (user.getPassword().equals(password))
            return "Successfully Logged in!";
        else
            return "Incorrect Username or Password!";
    }
}
