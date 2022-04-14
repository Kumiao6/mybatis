package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：m
 * @date ：Created in 2022/4/14 18:34
 */
@Mapper
public interface DynamicSQLMapper {
    /**
     * 多条件查询
     */
    List<Emp> getEmpCoundition(Emp emp);

    /**
     * 通过数组实现批量删除
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    /**
     * 通过list集合实现批量添加
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);

        /**
         * 获取所有员工的某些信息
         */
        List<Emp> getAllEmpNameAndAge();

}
