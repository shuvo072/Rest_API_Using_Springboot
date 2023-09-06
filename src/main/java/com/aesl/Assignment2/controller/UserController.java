package com.aesl.Assignment2.controller;

import com.aesl.Assignment2.entity.User;
import com.aesl.Assignment2.error.UserNotFoundException;
import com.aesl.Assignment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String openingMessage(){
        return "This is Assignment 2 of AESL";
    }

    @GetMapping("/get-users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/create-user")
    public User createAndSaveUser(@Valid @RequestBody User user){
        return userService.createAndSaveUser(user);
    }

    @PutMapping("/update-user/{id}")
    public User updateUser(@PathVariable("id") Long userId,@Valid @RequestBody User user) throws UserNotFoundException {
        return userService.updateUser(userId,user);
    }

    @DeleteMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable("id") Long userId) throws UserNotFoundException{
        return userService.deleteUser(userId);
    }
}
