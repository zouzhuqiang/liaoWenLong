package com.lwl.advertising.controller;

import com.lwl.advertising.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String toLogin(){
        return "user/login";
    }
    @PostMapping("/login")
    public String login(String userName,String password,Model model){
        return userService.login(userName,password,model);
    }
}
