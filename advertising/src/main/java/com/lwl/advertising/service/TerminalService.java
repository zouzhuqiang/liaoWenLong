package com.lwl.advertising.service;

import org.springframework.ui.Model;


public interface TerminalService {
    //展示全部终端
    String terminalDisplay(Model model);

    //根据id删除终端
    String terminalDelete(int id);

    //增加终端
    String terminalAdd(int id,String name,int areaId);

    //展示终端的广告
    String displayOne(int id,Model model);
}
