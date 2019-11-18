package com.lwl.advertising.service;

import org.springframework.ui.Model;

public interface AreaService {

    //展示全部区域
    String areaDisplay(Model model);

    //根据id删除区域
    String areaDelete(int id);

    //增加区域
    String areaAdd(String province,String city,String district,String street);

}
