package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import cn.edu.nwpu.salarymanagementsystem.service.StaffService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;

import static org.junit.Assert.*;

public class StaffMapperTest {

    ApplicationContext context;
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-dao.xml");

    }

    @Test
    public void test(){
      StaffMapper staffMapper = (StaffMapper)context.getBean("staffMapper");
      Staff staff = staffMapper.login("2019302919","123");
      System.out.println(staff);
    }
}