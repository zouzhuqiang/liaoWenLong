package com.lwl.advertising.service;

import org.springframework.ui.Model;

public interface AdvertisingService {
    String advertisingDisplay(Model model);

    String advertisingAdd(String source,String client);

    String advertisingDelete(int id);

    String advertisingDisplayOne(Model model,int id);
}
