package com.spring.rbac.controller;


import com.spring.rbac.model.Users;
import com.spring.rbac.service.UsersService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;


    @GetMapping("users")
    public ResponseEntity<List<Users>> fetchUsers(){
        List<Users> users = usersService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/users/{userName}")
    public ResponseEntity<Users> fetchUserByUserName(@PathVariable String userName){
        Users user = usersService.getUsersByUserName(userName);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody Users user){
        usersService.saveUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @PutMapping("/users")
    public ResponseEntity<String> updateuser(@RequestBody Users user){
        usersService.saveUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body("User updated successfully");
    }

    @DeleteMapping("/users/{userName}")
    public ResponseEntity<String> deleteUser(@PathVariable String userName) throws Exception {
        usersService.deleteUserByUserName(userName);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfullty");
    }

}
