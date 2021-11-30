package cn.edu.nwpu.salarymanagementsystem.service;

import cn.edu.nwpu.salarymanagementsystem.dao.AdministratorMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.DepartmentMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.SalaryMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
