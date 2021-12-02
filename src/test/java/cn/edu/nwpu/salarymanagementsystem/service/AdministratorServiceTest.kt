package cn.edu.nwpu.salarymanagementsystem.service

import org.junit.Before
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * 测试管理员和部门层级关系的测试类。
 */
class AdministratorServiceTest {

    private lateinit var administratorService: AdministratorService

    @Before
    fun initialService() {
        val context = ClassPathXmlApplicationContext("spring-service.xml")
        this.administratorService = context.getBean("administratorService") as AdministratorService
    }

    @Test
    fun departmentTest(){
        //TODO 部门测试
    }
}