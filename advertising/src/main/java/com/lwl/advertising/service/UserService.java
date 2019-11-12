package com.lwl.advertising.service;

import org.springframework.ui.Model;

public interface UserService {
    String login(String userName,String password,Model model);
}
