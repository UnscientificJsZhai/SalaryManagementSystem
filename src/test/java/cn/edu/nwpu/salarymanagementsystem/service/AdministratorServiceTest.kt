package cn.edu.nwpu.salarymanagementsystem.service

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.MutableDepartment
import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.MutableDepartment.TOP_LEVEL
import cn.edu.nwpu.salarymanagementsystem.pojo.exception.DepartmentLevelException
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
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
    fun departmentTest() {
        val d1 = MutableDepartment(1, "d1", null, TOP_LEVEL)
        val d2 = MutableDepartment(2, "d2", null, TOP_LEVEL)
        val d3 = MutableDepartment(3, "d3", 1, TOP_LEVEL + 1)
        val d4 = MutableDepartment(4, "d4", 1, TOP_LEVEL + 1)
        val d5 = MutableDepartment(5, "d5", 2, TOP_LEVEL + 1)
        val d6 = MutableDepartment(6, "d6", 4, TOP_LEVEL + 2)

        administratorService.addDepartment(d1)
        administratorService.addDepartment(d2)
        administratorService.addDepartment(d3)
        administratorService.addDepartment(d4)
        administratorService.addDepartment(d5)
        administratorService.addDepartment(d6)

        assertEquals(6, administratorService.departmentList.size)
        assertEquals(2, administratorService.departmentTree)

        administratorService.updateSingleDepartment(d1, "d111")
        val departments = administratorService.departmentList
        for (department in departments) {
            if (department.id == 1.toLong()) {
                assertEquals("d111", department.name)
            }
        }
    }

    /**
     * 测试部门约束是否生效。
     */
    @Test
    fun exceptionsTest() {
        // 层级为顶层，父不为空
        assertThrows(DepartmentLevelException::class.java) {
            MutableDepartment(100, "1", 1, TOP_LEVEL)
        }

        // 层级不为顶测，父为空
        assertThrows(DepartmentLevelException::class.java) {
            MutableDepartment(100, "1", null, TOP_LEVEL + 1)
        }

        val d1 = MutableDepartment(10001, "d10001", null, TOP_LEVEL)
        administratorService.addDepartment(d1)
        val d2 = MutableDepartment(10002, "d10002", d1.id, TOP_LEVEL + 2)
        assert(!administratorService.addDepartment(d2))
    }
}