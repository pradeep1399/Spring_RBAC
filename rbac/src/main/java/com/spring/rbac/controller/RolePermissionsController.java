package com.spring.rbac.controller;

import com.spring.rbac.dto.RolePermissionRequest;
import com.spring.rbac.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role-permissions")
public class RolePermissionsController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/link")
    public ResponseEntity<String> linkRoleToPermission(@RequestBody RolePermissionRequest request) {
        try {
            roleService.assignPermissionToRole(request.getRoleName(), request.getPermissionName());
            return ResponseEntity.status(HttpStatus.OK).body("Permission assigned to role successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error assigning permission to role.");
        }
    }

    @PostMapping("/delink")
    public ResponseEntity<String> delinkRoleFromPermission(@RequestBody RolePermissionRequest request) {
        try {
            roleService.removePermissionFromRole(request.getRoleName(), request.getPermissionName());
            return ResponseEntity.status(HttpStatus.OK).body("Permission removed from role successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error removing permission from role.");
        }
    }
}
