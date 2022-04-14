package com.atguigu.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：m
 * @date ：Created in 2022/4/13 23:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer eid;
    private String empName;
    private Integer age;
    private String  sex;
    private String email;
    private Dept dept;

    public Emp(Integer eid, String empName, Integer age, String sex, String email) {
        this.eid = eid;
        this.empName = empName;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }
}
