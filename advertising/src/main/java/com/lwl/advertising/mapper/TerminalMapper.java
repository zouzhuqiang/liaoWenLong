package com.lwl.advertising.mapper;

import com.lwl.advertising.domain.Terminal;
import com.lwl.advertising.domain.model.TerminalModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerminalMapper {

    @Select("SELECT terminal.*,province,city,district,street FROM terminal LEFT JOIN area ON terminal.area_id=area.id")
    List<TerminalModel> findAll();

    @Delete("DELETE FROM terminal WHERE id=#{id}")
    int deleteOne(@Param("id") int id);

    @Insert("INSERT INTO terminal(id,name,area_id) VALUES(#{id},#{name},#{areaId})")
    int addOne(@Param("id")int id,@Param("name") String name,@Param("areaId")int areaId);

    @Select("SELECT * FROM terminal WHERE id=#{id}")
    Terminal findById(@Param("id")int id);
}
