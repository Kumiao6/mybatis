package mybatis;

import com.atguigu.mybatis.mapper.SQLMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author ：m
 * @date ：Created in 2022/4/13 20:59
 */

public class SQLMapperTest {

    //    List<User> getUserByLike(@Param("username") String username);
    @Test
    public void getUserByLike() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);

        List<User> user = mapper.getUserByLike("U");
        System.out.println(user);
    }

    @Test
    public void deleteMore() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);

        int result = mapper.deleteMore("1,2");
        System.out.println(result);
    }

    @Test
    public void testGetUserByTableName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> t_user = mapper.getUserByTableName("t_user");
        System.out.println(t_user);
    }

    @Test
    public void testInsetUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        mapper.insetUser(new User(null, "兔兔","111",11,"f","abc@qq.com"));
    }

}
