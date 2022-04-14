package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ：m
 * @date ：Created in 2022/4/13 16:18
 */
@Mapper
public interface SelectMapper {

    /**
     * 1 、根据id查询用户信息
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 2、 查询所有用户信息
     */
    List<User> getAllUser();

    /**
     * 3、 查询用户信息的总记录数
     */
    Integer getCount(String ids);



    /**
     * 4、 查询所有用户信息为map集合，每一条记录是一个map
     */
    //方式一：
//    List<Map<String, Object>> getAllUserToMap();

    //方式二：
    @MapKey("id")
    Map<String, Object> getAllUserToMap();


}
