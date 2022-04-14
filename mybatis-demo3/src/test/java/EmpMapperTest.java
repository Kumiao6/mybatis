import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.annotations.Param;
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


//        List<Emp> emps = mapper.getAllEmpAndDept(1);
//        分步查询
        Emp emps = new Emp();
//        emps  = mapper.getEmpAndDeptByStepOne(1);

        System.out.println(emps);

    }

    @Test
    public void getEmpAndDeptByStepOne() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(1);
        System.out.println(emp.getEmpName());
    }

    @Test
    public void getEmpAndDeptByStepOne1() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(1);
        System.out.println(emp.getEmpName());
        System.out.println("----------------");
        System.out.println(emp.getDept());
    }

    //    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);
    @Test
    public void getEmpAndDeptByStep() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);

        Dept dept = new Dept();
        dept = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(dept);
    }

    @Test
    public void getEmpAndDeptByStepOne2() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(1);
//        System.out.println(emp);
        System.out.println("#######################");
        System.out.println(emp.getEmpName());
    }
}
