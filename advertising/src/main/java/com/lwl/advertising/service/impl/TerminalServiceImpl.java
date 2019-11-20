package com.lwl.advertising.service.impl;

import com.lwl.advertising.domain.Advertising;
import com.lwl.advertising.domain.Distribution;
import com.lwl.advertising.domain.Terminal;
import com.lwl.advertising.domain.model.TerminalModel;
import com.lwl.advertising.mapper.AdvertisingMapper;
import com.lwl.advertising.mapper.DistributionMapper;
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
    @Autowired
    private DistributionMapper distributionMapper;
    @Autowired
    private AdvertisingMapper advertisingMapper;


    @Override
    public String terminalDisplay(Model model) {
        List<TerminalModel> terminalModelList = terminalMapper.findAll();
        model.addAttribute("terminalModelList", terminalModelList);
        return "terminal/terminalDisplay";
    }

    @Override
    public String terminalDelete(int id) {
        terminalMapper.deleteOne(id);
        return "redirect:/Terminal/display/all";
    }

    @Override
    public String terminalAdd(int id, String name, int areaId) {
        String result;
        Terminal terminal = terminalMapper.findById(id);
        if (terminal != null) {
            result = "terminal/terminalAdd";
        } else {
            terminalMapper.addOne(id, name, areaId);
            result = "redirect:/Terminal/display/all";
        }
        return result;
    }

    @Override
    public String displayOne(int id, Model model) {
        Terminal terminal = terminalMapper.findById(id);
       // List<Distribution> distributionList = distributionMapper.findByTerminal(id);
        List<Advertising> imageList = advertisingMapper.findByTerminalAndFormat(id,"image");
        List<Advertising> videoList = advertisingMapper.findByTerminalAndFormat(id,"video");
        model.addAttribute("terminal",terminal);
        //model.addAttribute("distributionList",distributionList);
        model.addAttribute("imageList",imageList);
        model.addAttribute("videoList",videoList);
        return "terminal/displayOne";

    }
}
