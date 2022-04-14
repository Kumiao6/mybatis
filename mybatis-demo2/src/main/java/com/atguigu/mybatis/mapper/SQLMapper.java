package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：m
 * @date ：Created in 2022/4/13 20:55
 */
public interface SQLMapper {
    /**
     * 根据用户名模糊查询用户信息
     */
    List<User> getUserByLike(@Param("username") String username);

    /**
     * 批量删除
     */
    int deleteMore(String ids);

    /**
     * 查询指定表中的数据
     */
//    List<User> getUserByTableName(String tableName);
    List<User> getUserByTableName(String tableName);


    /**
     * 添加用户
     */
    void insetUser(User user);

}
