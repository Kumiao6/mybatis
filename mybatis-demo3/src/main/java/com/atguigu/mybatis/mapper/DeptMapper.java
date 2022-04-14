package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：m
 * @date ：Created in 2022/4/14 10:55
 */
public interface DeptMapper {

/**
* 分步查询的第二步:根据员工所对应的did查询部门信息
 */
        Dept getEmpAndDeptByStepTwo(@Param("did") int did);


        Dept getDeptAndEmpByStepOne(@Param("did") Integer eid);

}
