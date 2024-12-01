package com.spring.rbac.repository;

import com.spring.rbac.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findAll();
    User findByUserName(String userName);
    void deleteByUserName(String userName);
}
