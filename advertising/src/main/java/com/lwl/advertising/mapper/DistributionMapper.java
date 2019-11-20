package com.lwl.advertising.mapper;

import com.lwl.advertising.domain.Distribution;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistributionMapper {

    @Select("SELECT * FROM distribution WHERE terminal_id=#{terminalId}")
    List<Distribution> findByTerminal(@Param("terminalId")int terminalId);

    @Insert("INSERT INTO distribution(advertising_id,terminal_id)VALUES(#{advertisingId},#{terminalId})")
    int add(@Param("advertisingId")int advertisingId,@Param("terminalId")int terminalId);
}
