package com.lwl.advertising.mapper;

import com.lwl.advertising.domain.Area;
import com.lwl.advertising.domain.model.AreaModel;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaMapper {

    @Select("SELECT area.name AS province,a.name AS city,b.name AS district,c.name AS street\n" +
            "FROM area LEFT JOIN area a ON area.id=a.pid\n" +
            "LEFT JOIN area b ON a.id=b.pid\n" +
            "LEFT JOIN area c ON b.id=c.pid\n" +
            "WHERE area.pid=0")
    List<AreaModel> findAll();
}
