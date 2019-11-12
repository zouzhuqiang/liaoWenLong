package com.lwl.advertising.service.impl;

import com.lwl.advertising.mapper.UserMapper;
import com.lwl.advertising.domain.User;
import com.lwl.advertising.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UserServiceImpl  implements UserService {


    @Autowired
    private UserMapper userMapper;
    @Override
    public String login(String userName,String password,Model model){
        String page;
        User user = userMapper.findUserByUserName(userName);
        if(user == null){
            page = "user/login";
        }else{
            if(!user.getPassword().equals(password)){
                page = "user/login";
            }else{
                page = "user/admin";
                model.addAttribute("user",user);
            }
        }
        return page;
    }
}
