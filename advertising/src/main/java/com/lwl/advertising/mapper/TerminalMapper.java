package com.lwl.advertising.mapper;

import com.lwl.advertising.domain.Terminal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerminalMapper {
    @Select("SELECT * FROM terminal")
    List<com.lwl.advertising.domain.Terminal> findAll();

    @Delete("DELETE FROM terminal WHERE id=#{id}")
    int deleteOne(@Param("id") int id);

    @Insert("INSERT INTO terminal(number,name,province,city,district,street) VALUES(#{number},#{name},#{province},#{city},#{district},#{street})")
    int addOne(@Param("number") int number,@Param("name") String name,@Param("province")String province,@Param("city")String city,@Param("district")String district,@Param("street") String street);

    @Select("SELECT * FROM terminal WHERE street=#{street}")
    Terminal findByStreet(@Param("street")String street);
}
