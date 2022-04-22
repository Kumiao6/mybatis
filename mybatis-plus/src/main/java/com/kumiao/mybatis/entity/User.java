package com.kumiao.mybatis.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;

/**
 * @author ：m
 * @date ：Created in 2022/4/22 15:54
 */
@Mapper
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @TableField(fill = FieldFill.INSERT)
    private Data createTime;  //create_time

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Data updateTime; //update_time
}




