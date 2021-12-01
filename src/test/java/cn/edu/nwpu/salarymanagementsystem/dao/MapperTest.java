package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.administrator.Administrator;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.MutableDepartment;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.MutableSalary;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;


public class MapperTest {

    ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-dao.xml");

    }

    @Test
    public void test() throws SQLIntegrityConstraintViolationException {
        DepartmentMapper departmentMapper = (DepartmentMapper)context.getBean("departmentMapper");
        HashMap<String,Object> map = new HashMap<>();
        map.put(departmentMapper.ID,0);
        map.put(departmentMapper.NAME,"TEST");
        map.put(departmentMapper.PARENT,null);
        map.put(departmentMapper.LEVEL,0);
        departmentMapper.addDepartment(map);
    }
}