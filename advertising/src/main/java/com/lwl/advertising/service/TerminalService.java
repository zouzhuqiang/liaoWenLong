package com.lwl.advertising.service;

import org.springframework.ui.Model;


public interface TerminalService {
    //展示全部终端
    String terminalDisplay(Model model);

    //根据id删除终端
    String terminalDelete(int id);

    //增加终端
    String terminalAdd(int number,String name,String province,String city,String district,String street);
}
