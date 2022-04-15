import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kumiao.mybatis.mapper.EmpMapper;
import com.kumiao.mybatis.pojo.Emp;
import com.kumiao.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ：m
 * @date ：Created in 2022/4/15 11:51
 */
public class Test {

    @org.junit.Test
    public void test(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

            //查询所有数据
            System.out.println("\n--------->查询所有数据");
            List<Emp> emps = mapper.selectByExample(null); // 没有查询条件就相当于查询所有数据
            emps.forEach(emp -> System.out.println(emp));

            //根据条件查询 QBC: Query by Criteria
            EmpExample example = new EmpExample();

            //名字叫Bela的
            System.out.println("\n--------->根据条件查询");
            example.createCriteria().andEmpNameEqualTo("Bela");
            List<Emp> emps1 = mapper.selectByExample(example);
            emps1.forEach(emp -> System.out.println(emp));

            //链式添加条件
            System.out.println("\n--------->链式添加条件");
            example.createCriteria().andEmpNameEqualTo("Bela").andAgeEqualTo(33);
            List<Emp> emps2 = mapper.selectByExample(example);
            emps2.forEach(emp -> System.out.println(emp));

            //两个条件用or连接
            System.out.println("\n--------->两个条件用or连接");
            example.createCriteria().andAgeLessThan(30);
//            example.or().andDidIsNotNull();
            List<Emp> emps3 = mapper.selectByExample(example);
            emps3.forEach(emp -> System.out.println(emp));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * limit    index，pagesize
     * index    当前页的起始索引
     * pageSize 每页显示的条数
     * pageNum  当前页的页码
     * 当前页的起始索引 = 每页条数 * 页码 - 1
     * index = pageNum * pageSize - 1
     *
     * 通过索引获得数据
     *
     * 使用MyBatis的分页插件，实现分页功能：
     * 1。需要在查询功能之前开启分页
     * PageHelper.startPage(2, 4);
     *
     * 2。在查询功能之后获取分页相关信息
     *   PageInfo<Emp> pages = new PageInfo<>(emps, 5); 5表示导航分页的数量
     */
    @org.junit.Test
    public void test2(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

            System.out.println("\n查询功能前开启分页");

/*            PageHelper.startPage(2, 4);
            List<Emp> emps = mapper.selectByExample(null);
            emps.forEach(emp -> System.out.println(emp));

            System.out.println("\n");
            PageInfo<Emp> pages = new PageInfo<>(emps, 5);
            System.out.println("PageInfo----->"+pages);*/
            Page<Object> page  = PageHelper.startPage(4, 4);
            List<Emp> list = mapper.selectByExample(null);

            PageInfo<Emp> pageInfo = new PageInfo<>(list, 3);
            list.forEach(em1p -> System.out.println(em1p));

            System.out.println(pageInfo);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
