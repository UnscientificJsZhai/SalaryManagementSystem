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

public class MapperTest {

    ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-dao.xml");
    }

    /**
     * 部门dao接口测试
     */
    @Test
    public void testDepartment() throws SQLIntegrityConstraintViolationException {
        DepartmentMapper departmentMapper = (DepartmentMapper)context.getBean("departmentMapper");
//        HashMap<String,Object> map = new HashMap<>();
//        map.put(departmentMapper.ID,10);
//        map.put(departmentMapper.NAME,"sea");
//        map.put(departmentMapper.PARENT,1313);
//        map.put(departmentMapper.LEVEL,1);
//        departmentMapper.addDepartment(map);

//        departmentMapper.deleteById(11);
//        departmentMapper.deleteById(3123);
//        departmentMapper.deleteByParent(11);
//        departmentMapper.alterName("newName",11);
//        departmentMapper.alterName("newName",111231);
        List<MutableDepartment> list = departmentMapper.queryAll();
        System.out.println(list.size());
        for (MutableDepartment temp:list
             ) {
            System.out.println(temp);
        }



    }

    /**
     * 薪酬dao接口测试
     */
    @Test
    public void testSalary() throws SQLIntegrityConstraintViolationException {
        SalaryMapper salaryMapper = (SalaryMapper)context.getBean("salaryMapper");
//        HashMap<String,Object> map = new HashMap<>();
//        map.put(salaryMapper.ID,13123);
//        map.put(salaryMapper.MONTH,1);
//        map.put(salaryMapper.POST_WAGE,123);
//        map.put(salaryMapper.MERIT_PAY,123);
//        map.put(salaryMapper.SENIORITY_PAY,123);
//        map.put(salaryMapper.SUBSIDY,123);
//        map.put(salaryMapper.PAID,true);
//        salaryMapper.addSalary(map);
//        salaryMapper.deleteById(21313);
//        salaryMapper.deleteByMonth(1,1);
//        salaryMapper.deleteByMonth(113123,1);
//        HashMap<String,Object> map = new HashMap<>();
//        map.put(salaryMapper.POST_WAGE,777);
//        map.put(salaryMapper.MERIT_PAY,777);
//        map.put(salaryMapper.SENIORITY_PAY,777);
//        map.put(salaryMapper.SUBSIDY,777);
//        map.put(salaryMapper.PAID,false);
//        salaryMapper.alterSalary(map,1,2);
//        HashMap<String,Object> map = new HashMap<>();
//        //map.put(salaryMapper.POST_WAGE,777);
//        //map.put(salaryMapper.MERIT_PAY,777);
//        //map.put(salaryMapper.SENIORITY_PAY,777);
//        //map.put(salaryMapper.SUBSIDY,777);
//        //map.put(salaryMapper.PAID,false);
//        map.put("21312",123);
//        salaryMapper.alterSalary(map,1,2);
//        HashMap<String,Object> map = new HashMap<>();
//        map.put(salaryMapper.POST_WAGE,888);
//        //map.put(salaryMapper.MERIT_PAY,777);
//        //map.put(salaryMapper.SENIORITY_PAY,777);
//        //map.put(salaryMapper.SUBSIDY,777);
//        //map.put(salaryMapper.PAID,false);
//        salaryMapper.alterSalary(map,1,2);
            List<MutableSalary> list = salaryMapper.queryById(1);
        System.out.println(list.size());
        for (MutableSalary salary:list
             ) {
            System.out.println(salary);
        }
        list = salaryMapper.queryById(123123);
        System.out.println(list.size());
        MutableSalary salary  = salaryMapper.queryByMonth(1,2);
        System.out.println(salary);
        salary = salaryMapper.queryByMonth(1,12321);
        System.out.println(salary);
        salary =  salaryMapper.queryByMonth(123123,2);
        System.out.println(salary);





    }

}