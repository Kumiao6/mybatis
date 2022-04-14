import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author ：m
 * @date ：Created in 2022/4/14 11:01
 */
public class EmpMapperTest {

    @Test
    public void getAllEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        List<Emp> list = mapper.getAllEmp();


        list.forEach(emp -> System.out.println(emp));
    }

    //    List<Emp> getAllEmpAndDept();
    @Test
    public void getAllEmpAndDept() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        List<Emp> emps = mapper.getAllEmpAndDept(1);
        System.out.println(emps);
    }

}
