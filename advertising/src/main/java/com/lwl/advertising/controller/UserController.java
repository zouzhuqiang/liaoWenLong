package com.lwl.advertising.controller;

import com.lwl.advertising.domain.User;
import com.lwl.advertising.mapper.UserMapper;
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
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/")
    public String toLogin(){
        return "user/login";
    }
    @PostMapping("/login")
    public String login(String userName,String password,Model model){
        return userService.login(userName,password,model);
    }
    @RequestMapping("/message")
    public String message(String userName,Model model){
        User user = userMapper.findUserByUserName(userName);
        model.addAttribute(user);
        return "user/message";
    }

    @RequestMapping("/to/edit")
    public String toEdit(String userName,Model model){
        User user = userMapper.findUserByUserName(userName);
        model.addAttribute("user",user);
        return "user/edit";
    }

    @RequestMapping("/edit")
    public String edit(String userName,String password,String name,String phone,String sex,int age,Model model){
         userMapper.update(userName,password,name,phone,sex,age);
         User user = userMapper.findUserByUserName(userName);
         model.addAttribute("user",user);
         return "user/message";
    }

    @RequestMapping("/exit")
    public String exit(){
        return "user/login";
    }

    @RequestMapping("/to/first")
    public String toFirst(){
        return "user/first";
    }
}
