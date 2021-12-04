package cn.edu.nwpu.salarymanagementsystem.service;

import cn.edu.nwpu.salarymanagementsystem.dao.DepartmentMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.SalaryMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.StaffMapper;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.Department;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.MutableSalary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.Salary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import cn.edu.nwpu.salarymanagementsystem.utils.TaxUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 员工查询个人信息和工资情况的服务。
 *
 * @author UnscientificJsZhai
 * @version 1
 */
@Service
public class StaffService {

    private StaffMapper staffMapper;
    private SalaryMapper salaryMapper;
    private DepartmentMapper departmentMapper;

    @Autowired
    public void setStaffMapper(StaffMapper staffMapper) {
        this.staffMapper = staffMapper;
    }

    @Autowired
    public void setSalaryMapper(SalaryMapper salaryMapper) {
        this.salaryMapper = salaryMapper;
    }

    @Autowired
    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    /**
     * 登录，进行身份验证。
     *
     * @param staffId  用户名。
     * @param password 密码。
     * @return 是否登录成功。如果是，则返回true。
     */
    public boolean login(long staffId, @NotNull String password) {
        return staffMapper.login(staffId, password) != null;
    }

    /**
     * 获取用户个人信息。
     *
     * @param id 用户名。
     * @return 用户个人信息。
     */
    public Staff getPersonalInformation(long id) {
        return staffMapper.queryById(id);
    }

    /**
     * 更新用户个人信息。
     *
     * @param information 修改后的用户个人信息的数据类。
     */
    public void updatePersonalInformation(@NotNull Staff information) {
        final HashMap<String, Object> informationMap = new HashMap<>();

        informationMap.put(StaffMapper.ID, information.getId());
        informationMap.put(StaffMapper.EMAIL, information.getEmail());
        informationMap.put(StaffMapper.PHONE, information.getPhoneNumber());
        informationMap.put(StaffMapper.NAME, information.getName());
        staffMapper.alterProfile(informationMap);
    }

    /**
     * 更新密码。
     *
     * @param staffId     要更新的用户的ID。
     * @param newPassword 新密码，要求已经经过验证确认两次输入的值相同。
     */
    public void updatePassword(long staffId, @NotNull String newPassword) {
        final HashMap<String, Object> informationMap = new HashMap<>();

        informationMap.put(StaffMapper.ID, staffId);
        informationMap.put(StaffMapper.PASSWORD, newPassword);

        staffMapper.alterProfile(informationMap);
    }

    /**
     * 查询所有工资信息。
     *
     * @param id 用户名。
     * @return 工资信息。
     */
    public List<? extends Salary> getSalaryList(long id) {
        return salaryMapper.queryById(id);
    }

    /**
     * 通过部门编号查询获得部门名称。
     *
     * @param departmentId 部门编号。
     * @return 部门名称
     */
    @Nullable
    public String getDepartmentName(long departmentId) {
        final Department department = departmentMapper.queryById(departmentId);
        if (department == null) {
            return null;
        } else {
            return department.getName();
        }
    }

    /**
     * 计算个税。
     *
     * @param staff 要计算个税的用户。
     * @param year  时间范围（年）。1代表2000年，2代表2001年，以此类推。
     */
    public double calculateTax(long staff, int year) {
        final List<MutableSalary> salaryList = new ArrayList<>();

        for (int month = 1; month <= 12; month++) {
            MutableSalary salary = salaryMapper.queryByMonth(staff, (year - 1) * 12 + month);
            if (salary != null) {
                salaryList.add(salary);
            }
        }

        return TaxUtil.calculateTax(salaryList);
    }
}
