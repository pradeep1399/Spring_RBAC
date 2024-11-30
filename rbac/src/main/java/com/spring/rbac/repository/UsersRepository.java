package com.spring.rbac.repository;

import com.spring.rbac.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, String> {
    List<Users> findAll();
    Users findByUserName(String userName);
    void deleteByUserName(String userName);
}
