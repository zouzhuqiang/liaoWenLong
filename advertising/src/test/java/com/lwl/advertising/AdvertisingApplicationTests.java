package com.lwl.advertising;

import com.lwl.advertising.domain.model.AreaModel;
import com.lwl.advertising.mapper.AreaMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AdvertisingApplicationTests {

    @Autowired
    private AreaMapper areaMapper;
    @Test
    void contextLoads() {
    }
    @Test
    void testArea(){
        List<AreaModel> areaModelList = areaMapper.findAll();
        for(int i=0;i<areaModelList.size();i++){
            AreaModel areaModel = areaModelList.get(i);
            System.out.println("省："+areaModel.getProvince());
            System.out.println("市"+areaModel.getCity());
            System.out.println("区"+areaModel.getDistrict());
            System.out.println("街道"+areaModel.getStreet());
        }
    }
}
