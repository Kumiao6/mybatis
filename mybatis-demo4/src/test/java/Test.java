import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author ：m
 * @date ：Created in 2022/4/14 23:55
 */
public class Test {

    @org.junit.Test
    public void selectEmp() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);


        Emp emp = new Emp();
        emp =  mapper.selectByPrimaryKey(1);
        List<Emp> emps = mapper.selectAll();
    }
}
