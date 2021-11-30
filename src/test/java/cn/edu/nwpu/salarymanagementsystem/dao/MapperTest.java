package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;


public class MapperTest {

    ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-dao.xml");

    }

    @Test
    public void test() throws SQLIntegrityConstraintViolationException {
        StaffMapper  staffMapper = (StaffMapper) context.getBean("staffMapper");
        HashMap<String,String> map = new HashMap<>();
        map.put("username","2019302919");
        map.put("password","123456");
        //map.put("email","1365302167@qq.com");
        //map.put("phone","17390122291");
        //map.put("truename","wxy");
        staffMapper.alterProfile(map);

    }
}