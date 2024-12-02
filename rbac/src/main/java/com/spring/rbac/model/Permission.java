package com.spring.rbac.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "permissions")
public class Permission {

    @Id
    @Column(nullable = false)
    private String permissionName;

    @ManyToMany(mappedBy = "permissions")
    @JsonBackReference
    private Set<Role> roles;

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
