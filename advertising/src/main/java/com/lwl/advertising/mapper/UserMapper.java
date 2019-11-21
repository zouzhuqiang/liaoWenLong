package com.lwl.advertising.mapper;

import com.lwl.advertising.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Select("SELECT * FROM user WHERE username=#{userName}")
    User findUserByUserName(@Param("userName") String userName);

    @Update("UPDATE user SET username=#{userName},password=#{password}," +
            "name=#{name},phone=#{phone},sex=#{sex},age=#{age}")
    int update(@Param("userName")String userName,@Param("password")String password,@Param("name")String name,@Param("phone")String phone,
    @Param("sex")String sex,@Param("age")int age);

}
