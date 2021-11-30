package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLIntegrityConstraintViolationException;


public class StaffMapperTest {

    ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-dao.xml");

    }

    @Test
    public void test() throws SQLIntegrityConstraintViolationException {
        StaffMapper staffMapper = (StaffMapper) context.getBean("staffMapper");
        MutableStaff staff = new MutableStaff("2019302919", "yym", null, null, null);
        staffMapper.addStaff(staff, "123456");
    }
}