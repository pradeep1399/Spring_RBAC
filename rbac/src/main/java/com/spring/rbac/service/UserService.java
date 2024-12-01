package com.spring.rbac.service;

import com.spring.rbac.model.Role;
import com.spring.rbac.model.User;
import com.spring.rbac.repository.RoleRepository;
import com.spring.rbac.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // Remove this line since UserDTO is not a Spring bean
    // @Autowired private UserDTO userDTO;

    public List<User> getUser(){
        return userRepository.findAll();
    }

    public User getUserByUserName(String userName){
        User user = userRepository.findByUserName(userName);
        return user;
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void updateUser(User user){
        userRepository.save(user);
    }

    @Transactional
    public void deleteUserByUserName(String userName) throws Exception {
        User user = userRepository.findByUserName(userName);
        if(user != null) {
            userRepository.deleteByUserName(userName);
        } else {
            throw  new Exception("User not found");
        }
    }


    public void assignRoleToUser(String userName, String roleName) throws Exception {
        User user = userRepository.findById(userName).orElseThrow(() -> new Exception("User not found"));
        Role role = roleRepository.findById(roleName).orElseThrow(() -> new Exception("Role not found"));

        if (!user.getRoles().contains(role)) {
            user.getRoles().add(role);
            userRepository.save(user);
        } else {
            throw new Exception("Role already assigned to user");
        }
    }

    public void removeRoleFromUser(String userName, String roleName) throws Exception {
        User user = userRepository.findById(userName).orElseThrow(() -> new Exception("User not found"));
        Role role = roleRepository.findById(roleName).orElseThrow(() -> new Exception("Role not found"));

        if (user.getRoles().contains(role)) {
            user.getRoles().remove(role);
            userRepository.save(user);
        } else {
            throw new Exception("Role not assigned to user");
        }
    }
}
