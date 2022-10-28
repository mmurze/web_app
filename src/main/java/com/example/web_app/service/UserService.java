package com.example.web_app.service;


import com.example.web_app.entity.UserEntity;
import com.example.web_app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<UserEntity> listAll(){
        return (List<UserEntity>) userRepo.findAll();
    }
    public void save(UserEntity userEntity){
        userRepo.save(userEntity);
    }

    public void delete(Long id){
        userRepo.deleteById(id);
    }

}
