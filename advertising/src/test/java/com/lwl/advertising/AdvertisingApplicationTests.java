package com.lwl.advertising;

import com.lwl.advertising.domain.Advertising;
import com.lwl.advertising.domain.model.TerminalModel;
import com.lwl.advertising.mapper.AdvertisingMapper;
import com.lwl.advertising.mapper.AreaMapper;
import com.lwl.advertising.mapper.TerminalMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AdvertisingApplicationTests {

    @Autowired
    private AdvertisingMapper advertisingMapper;
    @Autowired
    private TerminalMapper terminalMapper;
    @Test
    void contextLoads() {
    }
    @Test
    void test(){
        List<TerminalModel> list = terminalMapper.findAll();
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getCity());
        }
    }
}
