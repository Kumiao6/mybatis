package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;

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
}
