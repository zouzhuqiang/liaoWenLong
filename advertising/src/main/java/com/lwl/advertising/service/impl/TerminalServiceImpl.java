package com.lwl.advertising.service.impl;

import com.lwl.advertising.domain.Terminal;
import com.lwl.advertising.mapper.TerminalMapper;
import com.lwl.advertising.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;


@Service
public class TerminalServiceImpl implements TerminalService {

    @Autowired
    private TerminalMapper terminalMapper;
    @Override
    public String terminalDisplay(Model model){
        List<Terminal> terminalList = terminalMapper.findAll();
        model.addAttribute("terminalList",terminalList);
        return "terminal/terminalDisplay";
    }

    @Override
    public String terminalDelete(int id){
        terminalMapper.deleteOne(id);
        return "redirect:/TerminalController/terminalDisplay";
    }

    @Override
    public String terminalAdd(int number,String name,String province,String city,String district,String street){
        String result;
        Terminal terminal = terminalMapper.findByStreet(street);
        if(terminal != null){
            result = "terminal/terminalAdd";
        }else{
            terminalMapper.addOne(number,name,province,city,district,street);
            result = "redirect:/TerminalController/terminalDisplay";
        }
        return result;
    }
}
