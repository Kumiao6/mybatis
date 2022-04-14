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

}
