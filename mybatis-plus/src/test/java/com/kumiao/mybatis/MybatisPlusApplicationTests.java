package com.kumiao.mybatis;

import com.kumiao.mybatis.entity.User;
import com.kumiao.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    void contextLoads() {

    }

    //修改
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1340868235401764865L);
        user.setName("lucymary");
        int count = userMapper.updateById(user);
        System.out.println(count);
    }


    //添加
    @Test
    public void testAdd() {
        User user = new User();
        user.setAge(20);
        user.setEmail("1234qq@qq.com");
        user.setName("123123");

        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

}
