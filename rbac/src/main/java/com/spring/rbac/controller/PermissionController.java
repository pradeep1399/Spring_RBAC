package com.spring.rbac.controller;

import com.spring.rbac.model.Permission;
import com.spring.rbac.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping
    public ResponseEntity<List<Permission>> fetchPermissions() {
        List<Permission> permissions = permissionService.getPermissions();
        return ResponseEntity.status(HttpStatus.OK).body(permissions);
    }

    @GetMapping("/{permissionName}")
    public ResponseEntity<Permission> fetchPermissionByName(@PathVariable String permissionName) {
        Permission permission = permissionService.getPermissionByName(permissionName);
        if (permission == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Return 404 if not found
        }
        return ResponseEntity.status(HttpStatus.OK).body(permission);
    }

    @PostMapping
    public ResponseEntity<String> createPermission(@RequestBody Permission permission) {
        permissionService.savePermission(permission);
        return ResponseEntity.status(HttpStatus.CREATED).body("Permission created successfully");
    }

    @PutMapping
    public ResponseEntity<String> updatePermission(@RequestBody Permission permission) {
        permissionService.savePermission(permission);
        return ResponseEntity.status(HttpStatus.OK).body("Permission updated successfully");
    }

    @DeleteMapping("/{permissionName}")
    public ResponseEntity<String> deletePermission(@PathVariable String permissionName) {
        boolean isDeleted = permissionService.deletePermissionByName(permissionName);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Permission not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Permission deleted successfully");
    }
}
