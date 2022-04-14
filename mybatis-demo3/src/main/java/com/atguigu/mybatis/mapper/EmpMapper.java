package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：m
 * @date ：Created in 2022/4/14 10:54
 */
@Mapper
public interface EmpMapper {
    List<Emp> getAllEmp();

    List<Emp> getAllEmpAndDept(int eid);
}
