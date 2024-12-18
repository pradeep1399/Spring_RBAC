package com.spring.rbac.repository;

import com.spring.rbac.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {
    Permission findByPermissionName(String permissionName);
}
