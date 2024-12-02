package com.spring.rbac.datainitializer;

import com.spring.rbac.model.Permission;
import com.spring.rbac.model.Role;
import com.spring.rbac.model.User;
import com.spring.rbac.repository.PermissionRepository;
import com.spring.rbac.repository.RoleRepository;
import com.spring.rbac.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public void run(String... args) throws Exception {
        Role sysAdminRole = roleRepository.findByRoleName("SYS_ADMIN");
        if (sysAdminRole == null) {
            // If role does not exist, create and save it
            sysAdminRole = new Role();
            sysAdminRole.setRoleName("SYS_ADMIN");
            roleRepository.save(sysAdminRole);
        }

        Set<Permission> permissions = new HashSet<>();

        String[] permissionNames = {"READ", "WRITE", "UPDATE", "DELETE"};
        for (String permissionName : permissionNames) {
            Permission permission = permissionRepository.findByPermissionName(permissionName);
            if (permission == null) {
                permission = new Permission();
                permission.setPermissionName(permissionName);
                permissionRepository.save(permission);
            }
            permissions.add(permission);
        }

        sysAdminRole.setPermissions(permissions);
        roleRepository.save(sysAdminRole);

        User sysUser = userRepository.findByUserName("sys_user");
        if (sysUser == null) {
            sysUser = new User();
            sysUser.setUserName("sys_user");
            sysUser.setPassword("sys_user");
            sysUser.setEmail("sys_user@gmail.com");

            Set<Role> roles = new HashSet<>();
            roles.add(sysAdminRole);
            sysUser.setRoles(roles);

            // Save the user
            userRepository.save(sysUser);
        }
    }
}
