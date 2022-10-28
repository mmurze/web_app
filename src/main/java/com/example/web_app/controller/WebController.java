package com.example.web_app.controller;

import com.example.web_app.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/api")
    public String index(Model model){
        model.addAttribute("user", new UserEntity());

        return "index";
}
}
