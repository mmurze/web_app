package com.example.web_app.service;


import com.example.web_app.entity.UserEntity;
import com.example.web_app.exception.MyException;
import com.example.web_app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void signUp(String firstName, String lastName, String email, String password) throws MyException {
        if (userRepo.findByEmail(email) != null)
            throw new MyException("This email has already been registered");

        UserEntity user = new UserEntity(firstName, lastName, email, password);
        userRepo.save(user);
    }

    public UserEntity signIn(String email, String password) throws MyException {
        UserEntity user = userRepo.findByEmail(email);
        if (user == null)
            throw new MyException("This email is not registered");
        if (!Objects.equals(user.getPassword(), password))
            throw new MyException("Incorrect password");
        return user;
    }


}
