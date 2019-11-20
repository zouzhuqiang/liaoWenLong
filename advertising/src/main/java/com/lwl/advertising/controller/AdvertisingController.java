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
    @RequestMapping("/toDistribution")
    public String toDistribution(Model model,Integer advertisingId){
        return advertisingService.toDistribution(model,advertisingId);
    }


    @RequestMapping("/distribution")
    public String distribution(Integer advertisingId,Integer terminalId){
        System.out.println(advertisingId);
        System.out.println(terminalId);
           return advertisingService.distribution(advertisingId,terminalId);
    }

}
