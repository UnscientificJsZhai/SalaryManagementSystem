package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLIntegrityConstraintViolationException;
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
        StaffMapper staffMapper = (StaffMapper) context.getBean("staffMapper");
        //登录测试
        Staff staff = staffMapper.login("2019302919","123456");
        System.out.println(staff);
        staff =  staffMapper.login("2019302919","123");
        System.out.println(staff);
        staff = staffMapper.login("2020302919","123456");
        System.out.println(staff);
        staff = staffMapper.login("2020302919","3123");
        System.out.println(staff);

        //查
        List<MutableStaff> list = staffMapper.queryAll();
        for (MutableStaff staff1:list
             ) {
            System.out.println(staff1);
        }
        staff = staffMapper.queryByUserName("2019302919");
        System.out.println(staff);
        list = staffMapper.queryByDepartment("sea");
        for (MutableStaff staff1:list
        ) {
            System.out.println(staff1);
        }
        staff = staffMapper.queryByTrueName("wqy");
        System.out.println(staff);


        //增加测试
        staffMapper.addStaff(new MutableStaff("2020302919","xly","17390122291","134@qq.com","college"),"123456");
        staffMapper.addStaff(new MutableStaff("2019302919","xly","17390122291","134@qq.com","college"),"123456");
        staffMapper.addStaff(new MutableStaff("2020302919","xly","1739012229","134@qq.com","college"),"123456");
        staffMapper.addStaff(new MutableStaff("2020302919","xly","17390122291","134@qq.com","root"),"123456");

        //删除
        staffMapper.deleteStaff("2019302919");
        staffMapper.deleteStaff("2020302919");
        staffMapper.deleteStaffByDepartment("sky");
        staffMapper.deleteStaffByDepartment("root");

        //更改
        staffMapper.alterDepartment("space","2019302922");
        staffMapper.alterDepartment("root","2019302922");
        staffMapper.alterDepartment("space","2029302922");


    }
}