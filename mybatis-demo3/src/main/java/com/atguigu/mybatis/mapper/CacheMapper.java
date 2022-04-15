package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：m
 * @date ：Created in 2022/4/14 21:56
 */
@Mapper
public interface CacheMapper {
    Emp getEmpById(@Param("eid") Integer eid);

    int insetEmp(Emp emp);
}
