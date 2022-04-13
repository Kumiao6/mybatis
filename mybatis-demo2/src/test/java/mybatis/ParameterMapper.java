package mybatis;


import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ：m
 * @date ：Created in 2022/4/13 10:44
 */
public class ParameterMapper {


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
        mapper.getUserByUserName("RUOYI");
        System.out.println(user);
    }


}
