import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：m
 * @date ：Created in 2022/4/14 18:39
 */
public class DynamitSQLMapperTest {

    /**
     * 动态sql
     * 1： if： 根据标签中test属性所对应的内容决定标签中的内容是否拼接在sql语句中
     */
    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        // 各信息都不为null/空字符串
/*        List<Emp> emp1 = mapper.getEmpCoundition(new Emp(null, "Apple", 22, "女", "123@gmail.com"));
        // 中间存在查询出来是空，可能导致"select * from t_emp where emp_name= ? and and sex = ?..."的and和and在一起的情况
        List<Emp> emp2 = mapper.getEmpCoundition(new Emp(null, "Apple", null, "女", "123@gmail.com"));
        // 第一个查询条件为空字符串，可能导致"select * from t_emp where and age = ? and ..."的where和and在一起的情况
        List<Emp> emp3 = mapper.getEmpCoundition(new Emp(null, null, null, "女", "123@gmail.com"));        System.out.println(emp1);
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);*/

        List<Emp> list = mapper.getEmpCoundition(new Emp(null, null, 1, "1", null));
        System.out.println(list);
    }

    //    int deleteMoreByArray(@Param("eids") Integer[] eids);
    @Test
    public void deleteMoreByArray() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);


        int result = mapper.deleteMoreByArray(new Integer[]{7, 8, 9, 10});
        System.out.println(result);
    }

    /**
     * 5、foreach
     *      collection  需要循环的数组或集合
     *      item        表示数组或集合中的每一个数据
     *      separator   循环体之间的分隔符
     *      open        foreach标签所循环的所有内容的开始符
     *      close       foreach标签所循环的所有内容的结束符
     */
    @Test
    public void testInsertMoreByList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "Mary", 23, "女", "11111@qq.com");
        Emp emp2 = new Emp(null, "Linda", 23, "女", "1144111@qq.com");
        Emp emp3 = new Emp(null, "Jackoline", 23, "女", "1122111@qq.com");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        System.out.println(mapper.insertMoreByList(emps));

    }

    /**
     * 6、sql片段
     *   设置：
     *   <sql id="empColumns">emp_name, age</sql>
     *   使用：
     *   select <include refid="empColumns"></include> from t_emp
     */
    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        System.out.println(mapper.getAllEmpNameAndAge());
    }

}
