package com.spring.rbac.service;

import com.spring.rbac.model.Users;
import com.spring.rbac.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getUsers(){
        return usersRepository.findAll();
    }

    public Users getUsersByUserName(String userName){
        return usersRepository.findByUserName(userName);
    }

    public void saveUser(Users user){
        usersRepository.save(user);
    }

    public void updateuser(Users user){
        usersRepository.save(user);
    }

    @Transactional
    public void deleteUserByUserName(String userName) throws Exception {
        Users user = usersRepository.findByUserName(userName);
        if(user != null) {
            usersRepository.deleteByUserName(userName);
        } else {
            throw  new Exception("user not found");
        }
    }
}
