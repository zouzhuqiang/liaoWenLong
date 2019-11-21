package com.lwl.advertising.controller;

import com.lwl.advertising.domain.Advertising;
import com.lwl.advertising.domain.Terminal;
import com.lwl.advertising.domain.model.TerminalModel;
import com.lwl.advertising.mapper.AdvertisingMapper;
import com.lwl.advertising.mapper.TerminalMapper;
import com.lwl.advertising.service.AdvertisingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/AdvertisingController")
public class AdvertisingController {

    @Autowired
    private AdvertisingService advertisingService;
    @Autowired
    private TerminalMapper terminalMapper;
    @Autowired
    private AdvertisingMapper advertisingMapper;

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
           return advertisingService.distribution(advertisingId,terminalId);
    }

    @RequestMapping("/to/schedule")
    public String toSchedule(Model model){
        List<TerminalModel> terminalModels = terminalMapper.findAll();
        List<Advertising> advertisings = advertisingMapper.findAll();
        model.addAttribute("terminalModels",terminalModels);
        model.addAttribute("advertisings",advertisings);
        return "/advertising/schedule";
    }

}
