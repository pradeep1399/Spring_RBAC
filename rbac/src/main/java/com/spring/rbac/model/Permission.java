package com.spring.rbac.model;

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
    private Set<Role> roles;

}
