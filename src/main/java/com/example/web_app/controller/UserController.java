package com.example.web_app.controller;


import com.example.web_app.entity.UserEntity;
import com.example.web_app.exception.MyException;
import com.example.web_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> SignUpPage(@RequestParam("firstName") String firstName,
                                             @RequestParam("lastName") String lastName,
                                             @RequestParam("email") String email,
                                             @RequestParam("password") String password) {

        try {
            userService.signUp(firstName, lastName, email, password);
            return ResponseEntity.ok("User was added ");
        } catch (MyException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("unknown error :(");
        }
    }

    @PostMapping("/signin")
    public ResponseEntity SignInPage(@RequestParam("email") String email,
                                     @RequestParam("password") String password) {
        try {
            UserEntity user = userService.signIn(email, password);
            return ResponseEntity.ok("User " + user.getEmail() + "log in :)");
        } catch (MyException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("unknown error :(");
        }
    }

}
