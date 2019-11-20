package com.lwl.advertising.mapper;

import com.lwl.advertising.domain.Advertising;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisingMapper {

    @Select("SELECT * FROM advertising")
    List<Advertising> findAll();

    @Insert("INSERT INTO advertising(source,client,format) VALUES(#{source},#{client},#{format})")
    int addOne(@Param("source")String source,@Param("client")String client,@Param("format") String format);

    @Select("SELECT * FROM advertising WHERE source=#{source}")
    Advertising findBySource(@Param("source")String source);

    @Delete("DELETE FROM advertising WHERE id=#{id}")
    int deleteOne(@Param("id") int id);

    @Select("SELECT * FROM advertising WHERE id=#{id}")
    Advertising findById(@Param("id")int id);

    @Select("SELECT advertising.* FROM terminal LEFT JOIN distribution ON terminal.id=distribution.terminal_id " +
            "LEFT JOIN advertising ON distribution.advertising_id=advertising.id WHERE terminal.id=#{terminalId} AND format=#{format}")
    List<Advertising> findByTerminalAndFormat(@Param("terminalId") int terminalId,@Param("format")String format);

}
