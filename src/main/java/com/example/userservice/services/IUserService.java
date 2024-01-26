package com.example.userservice.services;

import com.example.userservice.exceptions.userNotFoundException;
import com.example.userservice.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> getAllUsers();

    Optional<User> getSingleUser(Long id) throws userNotFoundException;

    User addNewUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id) throws userNotFoundException;


}
