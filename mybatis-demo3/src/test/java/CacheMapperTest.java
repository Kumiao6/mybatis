import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ：m
 * @date ：Created in 2022/4/14 21:59
 */
public class CacheMapperTest {
    @Test
    public void testCache(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpById(3);
        System.out.println(emp1);
        System.out.println("========第二次调用========从缓存中取数据");
        Emp emp2 = mapper.getEmpById(3);
        System.out.println(emp2);

        System.out.println("\n========即使用的不是同一个Mapper，也同样从缓存中取(同一个sqlsession)========");
        CacheMapper mapper2 = sqlSession.getMapper(CacheMapper.class);
        Emp empByMapper2 = mapper2.getEmpById(3);
        System.out.println(empByMapper2);


        System.out.println("\n========一级缓存的范围在sqlsession中，换一个新的sqlsession就会再次用sql读取数据========");
        SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper2BySqlSession2 = sqlSession2.getMapper(CacheMapper.class);
        System.out.println(mapper2BySqlSession2.getEmpById(3));
        SqlSession sqlSession1 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp empById = mapper.getEmpById(1);
        System.out.println(empById);

    }

    @Test
    public void testCache2(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);

        System.out.println("=====第一次获取数据=====");
        Emp emp1 = mapper.getEmpById(3);
        System.out.println(emp1);
        Emp emp2 = mapper.getEmpById(3);
        System.out.println(emp2);

        System.out.println("\n=====进行增删改操作=====");
        mapper.insetEmp(new Emp(null, "Joey1", 44, "男", "8888@gmai.com"));

        System.out.println("\n=====同一个sqlsession，再获取数据=====");
        Emp emp3 = mapper.getEmpById(3);
        System.out.println(emp3);
    }

    @Test
    public void testCache4(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);

        System.out.println("=====第一次获取数据=====");
        Emp emp1 = mapper.getEmpById(3);
        System.out.println(emp1);

        System.out.println("\n=====两次查询期间手动清空缓存=====");
        sqlSession.clearCache();

        System.out.println("\n=====再次查询id=3的emp=====");
        Emp emp2 = mapper.getEmpById(3);
        System.out.println(emp2);
    }

    @Test
    public void twoCache() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        CacheMapper mapper2 = sqlSession.getMapper(CacheMapper.class);

        System.out.println("=====第一次获取数据=====");
        Emp emp1 = mapper.getEmpById(2);
        System.out.println(emp1);
        sqlSession.close();

        System.out.println("二级缓存启动");
        Emp emp3 = mapper2.getEmpById(2);
        System.out.println(emp3);

    }


    @Test
    public void testCacheTwo(){
        //这里不能用工具类了，因为每次都会创建新的sqlsessionfactory
//        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
//        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);

        //只要是同一个sqlsessionfactory获得的sqlsession就可以
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper1.getEmpById(1));

            sqlSession1.close();

            System.out.println("Cache Hit Ratio：缓存命中率，指的是在缓存中有没有这条数据");
            System.out.println("=====二级缓存未打开，没从缓存中获取数据=====");
            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpById(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
