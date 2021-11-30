package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.MutableSalary;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLIntegrityConstraintViolationException;



public class MapperTest {

    ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-dao.xml");

    }

    @Test
    public void test() throws SQLIntegrityConstraintViolationException {
        SalaryMapper  salaryMapper = (SalaryMapper) context.getBean("salaryMapper");
        //salaryMapper.addSalary(new MutableSalary(1,122,122,122,12,false),"2019302919");
        salaryMapper.deleteSalaryByMonth("2019302919",3);
    }
}