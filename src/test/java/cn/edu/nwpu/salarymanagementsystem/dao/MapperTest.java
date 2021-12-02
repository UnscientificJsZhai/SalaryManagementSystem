package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.administrator.Administrator;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.MutableDepartment;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.MutableSalary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
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
        //DepartmentMapper departmentMapper = (DepartmentMapper)context.getBean("departmentMapper");
        //AdministratorMapper administratorMapper = (AdministratorMapper)context.getBean("administratorMapper");
        StaffMapper staffMapper = (StaffMapper)context.getBean("staffMapper");
/*        HashMap<String,Object> map = new HashMap<>();
        map.put(staffMapper.ID,2);
        map.put(staffMapper.PASSWORD,"123456");
        map.put(staffMapper.NAME,"staff1");
        map.put(staffMapper.PHONE,null);
        map.put(staffMapper.EMAIL,null);
        map.put(staffMapper.DEPARTMENT_ID,-1);*/
/*        List<MutableStaff> list = staffMapper.queryByDepartmentName("saads");
        System.out.println(list.size());
        for (MutableStaff staff:list
             ) {
            System.out.println(staff);
        }*/
        Staff staff = staffMapper.login(1,"12312");
        System.out.println(staff);

    }
}