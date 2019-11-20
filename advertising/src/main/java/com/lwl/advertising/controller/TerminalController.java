package com.lwl.advertising.controller;

import com.lwl.advertising.domain.Area;
import com.lwl.advertising.mapper.AreaMapper;
import com.lwl.advertising.service.AreaService;
import com.lwl.advertising.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Terminal")
public class TerminalController {

    @Autowired
    private TerminalService terminalService;
    @Autowired
    private AreaMapper areaMapper;

    @GetMapping("/display/all")
    public String terminalDisplay(Model model){
        return terminalService.terminalDisplay(model);
    }

    @GetMapping("/delete")
    public String terminalDelete(int id){
        return terminalService.terminalDelete(id);
    }

    @RequestMapping("/to/add")
    public String toAddTerminal(Model model){
        List<Area> areaList = areaMapper.findAll();
        model.addAttribute("areaList",areaList);
        return "terminal/terminalAdd";
    }

    @RequestMapping("/add")
    public String terminalAdd(int id,String name,int areaId){
        return terminalService.terminalAdd(id,name,areaId);
    }
    @RequestMapping("/display/one")
    public String displayOne(int id,Model model){
        return terminalService.displayOne(id,model);
    }
}
