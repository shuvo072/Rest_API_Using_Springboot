package com.aesl.Assignment2.service;

import com.aesl.Assignment2.entity.User;
import com.aesl.Assignment2.error.UserNotFoundException;
import com.aesl.Assignment2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createAndSaveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User user) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent())
        {
            throw new UserNotFoundException("User Not Found");
        }
        else
        {
            User userDB =userOptional.get();

            if(Objects.nonNull(user.getName()) &&
                    !"".equalsIgnoreCase(user.getName())) {
                userDB.setName(user.getName());
            }
            if(Objects.nonNull(user.getAddress()) &&
                    !"".equalsIgnoreCase(user.getAddress())) {
                userDB.setAddress(user.getAddress());
            }
            if(Objects.nonNull(user.getDob()) &&
                    !"".equalsIgnoreCase(user.getDob())) {
                userDB.setDob(user.getDob());
            }
            if(Objects.nonNull(user.getEmail()) &&
                    !"".equalsIgnoreCase(user.getEmail())) {
                userDB.setEmail(user.getEmail());
            }
            if(Objects.nonNull(user.getGender()) &&
                    !"".equals(user.getGender())) {
                userDB.setGender(user.getGender());
            }

            return userRepository.save(userDB);
        }
    }

    @Override
    public String deleteUser(Long userId) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent())
        {
            throw new UserNotFoundException("User Not Found");
        }
        else
        {
            User userDB = userOptional.get();
            userRepository.deleteById(userId);
            return "User Deleted Successfully";
        }
    }
}
