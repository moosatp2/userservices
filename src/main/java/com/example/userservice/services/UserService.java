package com.example.userservice.services;

import com.example.userservice.exceptions.userNotFoundException;
import com.example.userservice.models.User;
import com.example.userservice.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public User updateUser(Long id, User user) throws userNotFoundException {

        Optional<User> optionalUser = userRepo.findById(id);

        if(optionalUser.isEmpty()){
            throw new userNotFoundException("User not exist with id: " + id);
        }

        User savedUser = optionalUser.get();

        if(user.getName() != null){
            savedUser.setName(user.getName());
        }

        if(user.getEmail() != null){
            savedUser.setEmail(user.getEmail());
        }

        if(user.getPassword() != null){
            savedUser.setPassword(user.getPassword());
        }

        if(user.getAddress() != null){
            savedUser.setAddress(user.getAddress());
        }
        if(user.getPhone() !=null ){
            savedUser.setPhone(user.getPhone());
        }

        return userRepo.save(savedUser);
    }

    @Override
    public void deleteUser(Long id) throws userNotFoundException {

        if(userRepo.findById(id).isEmpty()){
            throw new userNotFoundException("Unable to delete. The entity with ID: " + id + " does not exist");
        }

        userRepo.deleteById(id);
    }
}
