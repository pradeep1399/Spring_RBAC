package com.spring.rbac.controller;


import com.spring.rbac.model.User;
import com.spring.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("users")
    public ResponseEntity<List<User>> fetchUser(){
        List<User> users = userService.getUser();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/users/{userName}")
    public ResponseEntity<User> fetchUserByUserName(@PathVariable String userName){
        User user = userService.getUserByUserName(userName);
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user){
        userService.saveUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @PutMapping("/users")
    public ResponseEntity<String> updateUser(@RequestBody User user){
        userService.saveUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body("User updated successfully");
    }

    @DeleteMapping("/users/{userName}")
    public ResponseEntity<String> deleteUser(@PathVariable String userName) throws Exception {
        userService.deleteUserByUserName(userName);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfullty");
    }

}
