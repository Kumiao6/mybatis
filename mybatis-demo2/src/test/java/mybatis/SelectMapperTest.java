package mybatis;

import com.atguigu.mybatis.mapper.SelectMapper;
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
import java.util.List;
import java.util.Map;

/**
 * @author ：m
 * @date ：Created in 2022/4/13 16:24
 */
public class SelectMapperTest {

    //    User getUserById(@Param("id") Integer id);
    /**
     * MyBatis的各种查询功能：
     * 1。 若查询出的数据只有一条，可以通过实体类对象 / list集合 / map集合 来接收
     * 2。 若查询处的数据有多条，一定不能通过实体类对象来接收，此时会抛出TooManyResultsException
     */
    @Test
    public void getUserByid() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SelectMapper mapper = build.openSession().getMapper(SelectMapper.class);


        User  user= mapper.getUserById(1);
        System.out.println(user);
    }


    /**
     * MyBatis的各种查询功能：
     * 1。 若查询出的数据只有一条，可以通过实体类对象 / list集合 / map集合 来接收
     * 2。 若查询处的数据有多条，一定不能通过实体类对象来接收，此时会抛出TooManyResultsException
     */
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(user -> System.out.println(user));
    }

    /**
     * 获取记录数
     *
     * MyBatis中设置了默认的类型别名
     * Java.lang.Integer -> int, integer
     * int -> _int, _integer
     * Map -> map
     * List -> list
     */
    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
//        System.out.println(mapper.getCount());
    }

    /**
     * 如果没有实体类对象，就把它映射成map集合
     * 从数据库中查询数据，将其映射为map集合
     * 例如把它传到网页端，就映射成json对象，所以转成map很常用
     * <p>
     * 以字段为键
     */
    @Test
    public void testgetUserByIdToMap() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);



        System.out.println();
    }



}
