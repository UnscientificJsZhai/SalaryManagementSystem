package cn.edu.nwpu.salarymanagementsystem.service;

import cn.edu.nwpu.salarymanagementsystem.dao.AdministratorMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.DepartmentMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.SalaryMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.StaffMapper;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 管理员进行各种操作的服务。
 *
 * @author UnscientificJsZhai
 * @version 1
 */
@Service
public class AdministratorService {

    private AdministratorMapper administratorMapper;
    private DepartmentMapper departmentMapper;
    private SalaryMapper salaryMapper;
    private StaffMapper staffMapper;

    @Autowired
    public void setAdministratorMapper(AdministratorMapper administratorMapper) {
        this.administratorMapper = administratorMapper;
    }

    @Autowired
    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Autowired
    public void setSalaryMapper(SalaryMapper salaryMapper) {
        this.salaryMapper = salaryMapper;
    }

    @Autowired
    public void setStaffMapper(StaffMapper staffMapper) {
        this.staffMapper = staffMapper;
    }

    /**
     * 添加员工。
     *
     * @param staff    新的员工信息。
     * @param password 初始密码。
     */
    public void addStaff(MutableStaff staff, String password) {
        try {
            staffMapper.addStaff(staff, password);
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        }
    }
}
