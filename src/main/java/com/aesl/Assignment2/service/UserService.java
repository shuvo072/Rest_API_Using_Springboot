package com.aesl.Assignment2.service;

import com.aesl.Assignment2.entity.User;
import com.aesl.Assignment2.error.UserNotFoundException;

import java.util.List;

public interface UserService {
    public List<User> getUsers();

    public User createAndSaveUser(User user);

    public User updateUser(Long userId, User user) throws UserNotFoundException;

    public String deleteUser(Long userId) throws UserNotFoundException;
}
