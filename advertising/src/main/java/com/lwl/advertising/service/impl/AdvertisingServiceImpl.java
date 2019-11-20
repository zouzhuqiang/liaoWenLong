package com.lwl.advertising.service.impl;

import com.lwl.advertising.domain.Advertising;
import com.lwl.advertising.domain.Terminal;
import com.lwl.advertising.domain.model.TerminalModel;
import com.lwl.advertising.mapper.AdvertisingMapper;
import com.lwl.advertising.mapper.DistributionMapper;
import com.lwl.advertising.mapper.TerminalMapper;
import com.lwl.advertising.service.AdvertisingService;
import com.lwl.advertising.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.io.File;
import java.util.List;

@Service
public class AdvertisingServiceImpl implements AdvertisingService {

    @Autowired
    private AdvertisingMapper advertisingMapper;
    @Autowired
    private TerminalMapper terminalMapper;
    @Autowired
    private DistributionMapper distributionMapper;

    @Override
    public String advertisingDisplay(Model model){
        List<Advertising> advertisingList = advertisingMapper.findAll();
        model.addAttribute("advertisingList",advertisingList);
        return "advertising/advertisingDisplay";
    }

    public String advertisingAdd(String source,String client){
        Advertising advertising = advertisingMapper.findBySource(source);
        if(advertising!=null){
            return "redirect:/AdvertisingController/advertisingDisplay";
        }else{

            String format;
            if(source.endsWith("jpg")){
                format="image";
            }else{
                format="video";
            }
            advertisingMapper.addOne(source,client,format);
            return "redirect:/AdvertisingController/advertisingDisplay";
        }
    }

    public String advertisingDelete(int id){
        Advertising advertising = advertisingMapper.findById(id);
        if(advertising != null){
            File file = new File("src//main//resources//static//file//"+advertising.getSource());
            file.delete();
            advertisingMapper.deleteOne(id);
        }
        return "redirect:/AdvertisingController/advertisingDisplay";
    }

    @Override
    public String advertisingDisplayOne(Model model,int id){
        Advertising advertising = advertisingMapper.findById(id);
        model.addAttribute("advertising",advertising);
        return "/advertising/advertisingOne";
    }

    @Override
    public String toDistribution(Model model,Integer advertisingId){
         List<TerminalModel> terminalList = terminalMapper.findAll();
         model.addAttribute("terminalList",terminalList);
         model.addAttribute("advertisingId",advertisingId);
         return "advertising/distribution";
    }

    @Override
    public String distribution(int advertisingId,int terminalId){
         distributionMapper.add(advertisingId,terminalId);
         return "redirect:/AdvertisingController/advertisingDisplay";
    }
}
