package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ：m
 * @date ：Created in 2022/4/12 21:31
 */
public class MyBatisTest {
    /**
     * sqlsession默认不自动提交事务，如果需要自动提交事务，可以使用SqlSessionFactory.openSession(true);
     * @throws IOException
     */
    @Test
    public void testInsertUser() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取sqlsessionfactorybuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取factory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class); //代理模式

        //测试功能
        int result = mapper.insertUser();

        //提交事务（写的type是JDBC）
//        sqlSession.commit();

        System.out.println("result: " + result);
    }

    @Test
    public void testUpdateUser() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser();
        System.out.println("updating...");

    }

    @Test
    public void testDeleteUser() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser();
        System.out.println("deleteUser-...");

    }

    @Test
    public void testSelectUser() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        /**
         * 如果不在UserMapper.xml中配置：
         * <select id="getAllUser" resultType="com.atguigu.mybatis.pojo.User">
         *
         * 会报错：A query was run and no Result Maps were found
         *           for the Mapped Statement 'com.atguigu.mybatis.mapper.UserMapper.getUserById'
         *          It's likely that neither a Result Type nor a Result Map was specified.
         *
         * com.atguigu.mybatis.mapper.UserMapper.getUserById： 命名空间.方法名
         *
         * 因此，要设置一个a Result Type nor a Result Map，这个type就是返回来的对应的类（要写全类名）
         *
         * 在UserMapper里进行设置
         */
        User user = mapper.getUserById();
        System.out.println(user);

        List<User> allUser = mapper.getAllUser();
        allUser.forEach(user1 -> System.out.println(user1));
    }
}


