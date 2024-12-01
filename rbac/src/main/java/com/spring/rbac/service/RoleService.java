package com.spring.rbac.service;

import com.spring.rbac.model.Permission;
import com.spring.rbac.model.Role;
import com.spring.rbac.repository.PermissionRepository;
import com.spring.rbac.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    // Fetch all roles
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    // Fetch a role by name
    public Role getRoleByName(String roleName) {
        Optional<Role> role = roleRepository.findById(roleName);
        return role.orElse(null);
    }

    // Save or update a role
    public void saveRole(Role role) {
        roleRepository.save(role);      }

    // Delete a role by name
    public boolean deleteRoleByName(String roleName) {
        if (roleRepository.existsById(roleName)) {
            roleRepository.deleteById(roleName);
            return true;
        }
        return false;
    }

    public void assignPermissionToRole(String roleName, String permissionName) throws Exception {
        Role role = roleRepository.findById(roleName).orElseThrow(() -> new Exception("Role not found"));
        Permission permission = permissionRepository.findById(permissionName).orElseThrow(() -> new Exception("Permission not found"));

        if (!role.getPermissions().contains(permission)) {
            role.getPermissions().add(permission);
            roleRepository.save(role);
        } else {
            throw new Exception("Permission already assigned to role");
        }
    }


    public void removePermissionFromRole(String roleName, String permissionName) throws Exception {
        Role role = roleRepository.findById(roleName).orElseThrow(() -> new Exception("Role not found"));
        Permission permission = permissionRepository.findById(permissionName).orElseThrow(() -> new Exception("Permission not found"));

        if (role.getPermissions().contains(permission)) {
            role.getPermissions().remove(permission);
            roleRepository.save(role);
        } else {
            throw new Exception("Permission not assigned to role");
        }
    }
}
