package com.example.web_app.controller;


import com.example.web_app.entity.UserEntity;
import com.example.web_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

//    {
//        "firstname": "{{$randomFirstName}}",
//            "lastname": "{{$randomLastName}}",
//            "email": "{{$randomEmail}}",
//            "password": "{{$randomPassword}}"
//    }

    @PostMapping("/new")
    public ResponseEntity registration (@RequestBody UserEntity user){
        try {
            userService.save(user);
            return ResponseEntity.ok("User was created ");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error... (");
        }
    }
    @GetMapping("/list")
    public ResponseEntity showUserList(){
        try {
            List<UserEntity> userList = userService.listAll();
            String str = "";
            for (UserEntity u : userList){
                str = str + u.toString() + "\n";
                System.out.println(str);
            }
            return ResponseEntity.ok("Users : \n" + str);
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error... (");
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable Long id) {
        try {
            userService.delete(id);
            return ResponseEntity.ok("User was deleted  \n");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error... (");
        }
    }
}
