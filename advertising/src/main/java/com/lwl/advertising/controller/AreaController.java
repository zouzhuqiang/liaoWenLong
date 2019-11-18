package com.lwl.advertising.controller;

import com.lwl.advertising.domain.Area;
import com.lwl.advertising.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/AreaController")
public class AreaController {

    @Autowired
    private AreaService areaService;
    @GetMapping("/areaDisplay")
    public String areaDisplay(Model model){
        return areaService.areaDisplay(model);
    }

    @GetMapping("/areaDelete")
    public String areaDelete(int id){
        return areaService.areaDelete(id);
    }

    @RequestMapping("/toAddArea")
    public String toAddArea(){
        return "area/areaAdd";
    }

    @RequestMapping("/areaAdd")
    public String areaAdd(String province,String city,String district,String street){
        return areaService.areaAdd(province,city,district,street);
    }
}
