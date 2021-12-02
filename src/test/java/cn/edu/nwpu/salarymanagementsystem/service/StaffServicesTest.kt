package cn.edu.nwpu.salarymanagementsystem.service

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.DepartmentTreeNode
import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.MutableDepartment
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.MutableSalary
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * 员工Service测试。需要数据库环境才能进行测试。
 *
 * @author UnscientificJsZhai
 */
class StaffServicesTest {

    companion object {

        /**
         * 薪水最大允许误差。
         */
        const val DELTA: Double = 0.01
    }

    private lateinit var staffService: StaffService
    private lateinit var administratorService: AdministratorService

    @Before
    fun initialService() {
        val context = ClassPathXmlApplicationContext("spring-service.xml")
        this.staffService = context.getBean("staffService") as StaffService
        this.administratorService = context.getBean("administratorService") as AdministratorService

        administratorService.clearStaff()

        administratorService.clearDepartment()
    }

    /**
     * 测试管理员添加员工和员工信息查询，以及员工信息更改。
     */
    @Test
    fun addStaffTest() {
        val staff = MutableStaff(
            20121212123, "员工A", "12312341234", "test@example.com", null
        )

        administratorService.addStaff(staff, "password123")
        assert(staffService.login(staff.id, "password123"))

        val queryStaff = staffService.getPersonalInformation(staff.id)
        assertEquals(staff.name, queryStaff.name)
        assertEquals(staff.phoneNumber, queryStaff.phoneNumber)
        assertEquals(staff.email, queryStaff.email)

        queryStaff.name = "员工B"
        queryStaff.phoneNumber = "1231234321"
        queryStaff.email = "test2@example.com"
        staffService.updatePersonalInformation(queryStaff)

        val queryStaff2 = staffService.getPersonalInformation(staff.id)
        assertEquals(queryStaff.name, queryStaff2.name)
        assertEquals(queryStaff.phoneNumber, queryStaff2.phoneNumber)
        assertEquals(queryStaff.email, queryStaff2.email)

        staffService.updatePassword(staff.id, "password456")
        assert(!staffService.login(staff.id, "password123"))
        assert(staffService.login(staff.id, "password456"))
    }

    /**
     * 测试员工信息和部门信息绑定。
     */
    @Test
    fun staffDepartmentTest() {
        val departmentA = MutableDepartment(1, "部门A", null, 1)
        val departmentB = MutableDepartment(2, "部门B", null, 1)
        administratorService.addDepartment(departmentA)
        administratorService.addDepartment(departmentB)

        assertEquals(departmentA.name, staffService.getDepartmentName(departmentA.id))
        assertEquals(departmentB.name, staffService.getDepartmentName(departmentB.id))

        val staff = MutableStaff(
            20121212321, "员工C", "12312341234", "test@example.com", 1
        )
        administratorService.addStaff(staff, "123456q")
        val addedStaff = staffService.getPersonalInformation(staff.id)
        assertEquals(departmentA.name, staffService.getDepartmentName(addedStaff.department))

        administratorService.updateStaffDepartment(staff.id, departmentB.id)
        val departmentChangedStaff = staffService.getPersonalInformation(staff.id)
        assertEquals(departmentB.name, staffService.getDepartmentName(departmentChangedStaff.department))
    }

    /**
     * 薪水信息测试。
     */
    @Test
    fun salaryTest() {
        val staff = MutableStaff(
            20121212789, "员工C", "12312341234", "test@example.com", null
        )
        administratorService.addStaff(staff, "123pass")

        val salary1 = MutableSalary(
            1,
            1000.0,
            1000.0,
            1000.0,
            1000.0,
            true
        )

        val salary2 = MutableSalary(
            2,
            2000.0,
            1000.0,
            2000.0,
            1000.0,
            false
        )

        administratorService.setSalary(staff.id, salary1)
        administratorService.setSalary(staff.id, salary2)

        val salaryList = staffService.getSalaryList(staff.id)
        assertEquals(salaryList.size, 2)
        for (salary in salaryList) {
            if (salary.month == 1) {
                assertEquals(salary1.postWage, salary.postWage, DELTA)
                assertEquals(salary1.meritPay, salary.meritPay, DELTA)
                assertEquals(salary1.seniorityPay, salary.seniorityPay, DELTA)
                assertEquals(salary1.subsidy, salary.subsidy, DELTA)
            } else {
                assertEquals(salary2.postWage, salary.postWage, DELTA)
                assertEquals(salary2.meritPay, salary.meritPay, DELTA)
                assertEquals(salary2.seniorityPay, salary.seniorityPay, DELTA)
                assertEquals(salary2.subsidy, salary.subsidy, DELTA)
            }
        }

        salary2.isPaid = true
        administratorService.updateSalary(staff, salary2)
        val newList = administratorService.getSalaryListByStaff(staff.id)
        for (salary in newList) {
            if (salary.month == 2) {
                assertEquals(true, salary.isPaid)
            }
        }
    }

    /**
     * 清理部门信息和员工信息。
     */
    @After
    fun delete() {
        val staffList = administratorService.staffList
        for (staff in staffList) {
            administratorService.removeStaff(staff.id)
        }

        val departments = administratorService.departmentList
        departments.sortWith(DepartmentTreeNode.DepartmentLevelComparator())
        departments.reverse()
        for (department in departments) {
            administratorService.deleteDepartments(department.id)
        }
    }
}