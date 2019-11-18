package com.lwl.advertising.mapper;

import com.lwl.advertising.domain.Area;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaMapper {

    @Select("SELECT * FROM area")
    List<Area> findAll();

    @Delete("DELETE FROM area WHERE id=#{id}")
    int deleteOne(@Param("id") int id);

    @Insert("INSERT INTO area(province,city,district,street) VALUES(#{province},#{city},#{district},#{street})")
    int addOne(@Param("province")String province,@Param("city")String city,@Param("district")String district,@Param("street") String street);

    @Select("SELECT * FROM area WHERE street=#{street}")
    Area findByStreet(@Param("street")String street);
}
