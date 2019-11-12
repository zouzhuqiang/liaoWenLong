package com.lwl.advertising.service.impl;

import com.lwl.advertising.domain.model.AreaModel;
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
        List<AreaModel> areaModelList = areaMapper.findAll();
        model.addAttribute("areaModelList",areaModelList);
        return "area/areaDisplay";
    }
}
