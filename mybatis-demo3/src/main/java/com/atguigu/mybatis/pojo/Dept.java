package com.atguigu.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：m
 * @date ：Created in 2022/4/13 23:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private Integer did;
    private String deptName;
}
