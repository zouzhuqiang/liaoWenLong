package com.lwl.advertising.controller;

import com.lwl.advertising.service.AdvertisingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/AdvertisingController")
public class AdvertisingController {

    @Autowired
    private AdvertisingService advertisingService;

    @RequestMapping("/advertisingDisplay")
    public String advertisingDisplay(Model model){
        return advertisingService.advertisingDisplay(model);
    }

    @RequestMapping("/advertisingDelete")
    public String advertisingDelete(int id){
        return advertisingService.advertisingDelete(id);
    }

    @RequestMapping("/advertisingDisplayOne")
    public String advertisingDisplayOne(Model model,int id){
        return advertisingService.advertisingDisplayOne(model,id);
    }
}
