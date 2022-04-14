package mybatis;


import com.atguigu.mybatis.mapper.ParameterMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：m
 * @date ：Created in 2022/4/13 10:44
 */
public class ParameterMapperTest {


    /**
     * MyBatis获取参数值的各种情况：
     * 情况1： mapper接口方法的参数为单个字面量的参数
     * 可以通过${} #{}以任意的字符串获得参数值，但需要注意${}的单引号问题
     */
    @Test
    public void testgetUserByUserName() throws IOException {


        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取sqlsessionfactorybuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取factory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口对象
        com.atguigu.mybatis.mapper.ParameterMapper mapper = sqlSession.getMapper(com.atguigu.mybatis.mapper.ParameterMapper.class);//代理模式



        User user = new User();
        mapper.getUserByUserName("RUOYI","password");
        System.out.println(user);
    }

    @Test
    public void testJDBC() throws SQLException, ClassNotFoundException {
        String username = "cherry";
        Class.forName("");
        Connection connection = DriverManager.getConnection("", "", "");
        // 1. 字符串拼接 ->获得预编译对象 -》sql注入问题
        PreparedStatement preparedStatement = connection.prepareStatement("select * from t_user where username = '" + username + "'");

        // 2. 占位符
        PreparedStatement ps2 = connection.prepareStatement("select * from t_user where username = ?");
        ps2.setString(1, username);
    }


    //    <!--    User checkLogin(String username, String password);-->
    @Test
    public void checkLogin() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapperTest mapper = sqlSession.getMapper(ParameterMapperTest.class);
//        User user = mapper.checkLogin("RUOYI");
//        System.out.println(user);
    }


    /**
     * 验证登录
     */
//    User checkLoginByMap(Map<String, Object> map);
    @Test
    public void checkLoginByMap() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("username", "RUOYI");
        map.put("password", "456");



        User user = mapper.checkLoginByMap(map);

        System.out.println(user);


    }

    //    int insertUser(User user);
    @Test
    public void insertUser() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);


        User user = new User(1112, "Pandora", "4444", 66, "m", "1111@gmail.com");
        int result = mapper.insertUser(user);
        System.out.println(result);

    }


    //    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
    @Test
    public void checkLoginByParam() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);

        User user = mapper.checkLoginByParam("RUOYI","123456");
        System.out.println(user);

    }








}
