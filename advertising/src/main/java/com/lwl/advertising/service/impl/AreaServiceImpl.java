package com.lwl.advertising.service.impl;

import com.lwl.advertising.mapper.AreaMapper;
import com.lwl.advertising.domain.Area;
import com.lwl.advertising.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;
    @Override
    public String areaDisplay(Model model){
        List<Area> areaList = areaMapper.findAll();
        model.addAttribute("areaList",areaList);
        return "area/areaDisplay";
    }

    @Override
    public String areaDelete(int id){
        areaMapper.deleteOne(id);
        return "redirect:/AreaController/areaDisplay";
    }

    @Override
    public String areaAdd(String province,String city,String district,String street){
        String result;
        Area area = areaMapper.findByStreet(street);
        if(area != null){
             result = "area/areaAdd";
        }else{
            areaMapper.addOne(province,city,district,street);
            result = "redirect:/AreaController/areaDisplay";
        }
        return result;
    }
}
