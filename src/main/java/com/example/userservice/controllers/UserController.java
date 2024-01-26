package com.example.userservice.controllers;

import com.example.userservice.exceptions.userNotFoundException;
import com.example.userservice.models.User;
import com.example.userservice.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() throws NoResourceFoundException  {

        ResponseEntity<List<User>>  responseEntity =
                new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getSingleUser(@PathVariable("id") Long id) throws userNotFoundException {

        ResponseEntity<Optional<User>> responseEntity =
                new ResponseEntity<>(userService.getSingleUser(id), HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping()
        public ResponseEntity<User> addNewUser(@RequestBody() User user){

        ResponseEntity<User> userResponseEntity =
                new ResponseEntity<>(userService.addNewUser(user), HttpStatus.OK);
        return userResponseEntity;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id")Long id, @RequestBody() User user){
        return null;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id")Long id) throws userNotFoundException {

        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
