package com.lwl.advertising.controller;

import com.lwl.advertising.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
