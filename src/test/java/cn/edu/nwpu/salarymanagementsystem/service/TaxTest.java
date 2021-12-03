package cn.edu.nwpu.salarymanagementsystem.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TaxTest
 * @Description TODO
 * @Author mikasa
 * @Date 2021/12/3
 * @Version 1.0
 */
public class TaxTest {

    private StaffService service;

    @Before
    public void initial(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml");
        this.service = (StaffService) context.getBean("staffService");
    }

    @Test
    public void taxTestWithService(){
        //service.calculateTax()
    }
}
