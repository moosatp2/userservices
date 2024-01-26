package com.example.userservice.services;

import com.example.userservice.exceptions.userNotFoundException;
import com.example.userservice.models.User;
import com.example.userservice.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    public final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getSingleUser(Long id) throws userNotFoundException {
        Optional<User> user = userRepo.findById(id);
        if(user.isEmpty()){
            throw new userNotFoundException("User not exist with id: " + id);
        }
        return user;
    }

    @Override
    public User addNewUser(User user) {

        User user1 = userRepo.save(user);
        return user1;
    }

    @Override
    public User updateUser(Long id, User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) throws userNotFoundException {

        if(userRepo.findById(id).isEmpty()){
            throw new userNotFoundException("Unable to delete. The entity with ID: " + id + " does not exist");
        }

        userRepo.deleteById(id);
    }
}
