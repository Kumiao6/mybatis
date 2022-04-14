package com.atguigu.mybatis.mapper;


import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author ：m
 * @date ：Created in 2022/4/13 10:37
 */
@Mapper
public interface ParameterMapper {
    /**
     * 单个的字面量类型：
     * 根据用户查询用户信息
     */
    User getUserByUserName(String username);
    User getUserByUserName(String username,String password);

    /**
     * 验证登录
     */
    User checkLogin(String username);

    /**
         * 验证登录
         */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 添加用户信息
     */
    int insertUser(User user);

    /**
     * 验证登录 （使用@Param）
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
