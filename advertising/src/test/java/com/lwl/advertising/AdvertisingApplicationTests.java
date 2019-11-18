package com.lwl.advertising;

import com.lwl.advertising.domain.Advertising;
import com.lwl.advertising.mapper.AdvertisingMapper;
import com.lwl.advertising.mapper.AreaMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AdvertisingApplicationTests {

    @Autowired
    private AdvertisingMapper advertisingMapper;
    @Test
    void contextLoads() {
    }
    @Test
    void test(){
       List<Advertising> advertisingList = advertisingMapper.findAll();
       for(int i=0;i<advertisingList.size();i++){
           Advertising advertising = advertisingList.get(i);
           System.out.println(advertising.getId()+advertising.getSource()+advertising.getClient());
       }
    }
}
