package com.lwl.advertising.mapper;

import com.lwl.advertising.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Select("SELECT * FROM user WHERE username=#{userName}")
    User findUserByUserName(@Param("userName") String userName);
}
