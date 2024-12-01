package com.spring.rbac.service;

import com.spring.rbac.model.Permission;
import com.spring.rbac.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    // Fetch all permissions
    public List<Permission> getPermissions() {
        return permissionRepository.findAll();
    }

    // Fetch a permission by name
    public Permission getPermissionByName(String permissionName) {
        Optional<Permission> permission = permissionRepository.findById(permissionName);
        return permission.orElse(null);
    }

    // Save or update a permission
    public void savePermission(Permission permission) {
        permissionRepository.save(permission);      }

    // Delete a permission by name
    public boolean deletePermissionByName(String permissionName) {
        if (permissionRepository.existsById(permissionName)) {
            permissionRepository.deleteById(permissionName);
            return true;
        }
        return false;
    }
}
