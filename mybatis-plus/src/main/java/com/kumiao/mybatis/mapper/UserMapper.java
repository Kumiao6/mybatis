package com.kumiao.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kumiao.mybatis.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author ：m
 * @date ：Created in 2022/4/22 15:59
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    //BaseMapper接口提供了大量的crud方法，无需自己再五一一实现


}
