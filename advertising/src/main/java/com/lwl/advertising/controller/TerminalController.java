package com.lwl.advertising.controller;

import com.lwl.advertising.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/TerminalController")
public class TerminalController {

    @Autowired
    private TerminalService terminalService;
    @GetMapping("/terminalDisplay")
    public String terminalDisplay(Model model){
        return terminalService.terminalDisplay(model);
    }

    @GetMapping("/terminalDelete")
    public String terminalDelete(int id){
        return terminalService.terminalDelete(id);
    }

    @RequestMapping("/toAddTerminal")
    public String toAddTerminal(){
        return "terminal/terminalAdd";
    }

    @RequestMapping("/terminalAdd")
    public String terminalAdd(int number,String name,String province,String city,String district,String street){
        return terminalService.terminalAdd(number,name,province,city,district,street);
    }
}
