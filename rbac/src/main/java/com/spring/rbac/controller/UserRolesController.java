package com.spring.rbac.controller;

import com.spring.rbac.dto.UserRoleRequest;
import com.spring.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-roles")
public class UserRolesController {

    @Autowired
    private UserService userService;

    @PostMapping("/link")
    public ResponseEntity<String> linkUserToRole(@RequestBody UserRoleRequest request) {
        try {
            userService.assignRoleToUser(request.getUserName(), request.getRoleName());
            return ResponseEntity.status(HttpStatus.OK).body("Role assigned to user successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error assigning role to user.");
        }
    }

    @PostMapping("/delink")
    public ResponseEntity<String> delinkUserFromRole(@RequestBody UserRoleRequest request) {
        try {
            userService.removeRoleFromUser(request.getUserName(), request.getRoleName());
            return ResponseEntity.status(HttpStatus.OK).body("Role removed from user successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error removing role from user.");
        }
    }
}
