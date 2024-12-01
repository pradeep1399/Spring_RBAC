package com.spring.rbac.controller;

import com.spring.rbac.model.Role;
import com.spring.rbac.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")  // RESTful endpoint for roles
public class RoleController {

    @Autowired
    private RoleService roleService;

    // Fetch all roles
    @GetMapping
    public ResponseEntity<List<Role>> fetchRoles() {
        List<Role> roles = roleService.getRoles();
        return ResponseEntity.status(HttpStatus.OK).body(roles);
    }

    // Fetch a role by name
    @GetMapping("/{roleName}")
    public ResponseEntity<Role> fetchRoleByName(@PathVariable String roleName) {
        Role role = roleService.getRoleByName(roleName);
        if (role == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Return 404 if not found
        }
        return ResponseEntity.status(HttpStatus.OK).body(role);
    }

    // Create a new role
    @PostMapping
    public ResponseEntity<String> createRole(@RequestBody Role role) {
        roleService.saveRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).body("Role created successfully");
    }

    // Update an existing role
    @PutMapping
    public ResponseEntity<String> updateRole(@RequestBody Role role) {
        roleService.saveRole(role);
        return ResponseEntity.status(HttpStatus.OK).body("Role updated successfully");
    }

    // Delete a role by name
    @DeleteMapping("/{roleName}")
    public ResponseEntity<String> deleteRole(@PathVariable String roleName) {
        boolean isDeleted = roleService.deleteRoleByName(roleName);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Role deleted successfully");
    }
}
