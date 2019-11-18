package com.lwl.advertising.service.impl;

import com.lwl.advertising.domain.Advertising;
import com.lwl.advertising.mapper.AdvertisingMapper;
import com.lwl.advertising.service.AdvertisingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class AdvertisingServiceImpl implements AdvertisingService {

    @Autowired
    private AdvertisingMapper advertisingMapper;
    @Override
    public String advertisingDisplay(Model model){
        List<Advertising> advertisingList = advertisingMapper.findAll();
        model.addAttribute("advertisingList",advertisingList);
        return "advertising/advertisingDisplay";
    }

    public String advertisingAdd(String source,String client){
        Advertising advertising = advertisingMapper.findBySource(source);
        if(advertising!=null){
            return "file/upload";
        }else{
            advertisingMapper.addOne(source,client);
            return "advertising/advertisingDisplay";
        }
    }

    public String advertisingDelete(int id){
        advertisingMapper.deleteOne(id);
        return "advertising/advertisingDisplay";
    }

    @Override
    public String advertisingDisplayOne(Model model,int id){
        Advertising advertising = advertisingMapper.findById(id);
        model.addAttribute("advertising",advertising);
        return "/advertising/advertisingOne";
    }
}
