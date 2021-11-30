package cn.edu.nwpu.salarymanagementsystem.service;

import cn.edu.nwpu.salarymanagementsystem.dao.DepartmentMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.SalaryMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.StaffMapper;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

    public void setSalaryMapper(SalaryMapper salaryMapper) {
        this.salaryMapper = salaryMapper;
    }

    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    /**
     * 登录，进行身份验证。
     *
     * @param username 用户名。
     * @param password 密码。
     * @return 是否登录成功。如果是，则返回true。
     */
    public boolean login(String username, String password) {
        //TODO 数据库操作
        return false;
    }

    public Staff getPersonalInformation(String username) {
        //TODO 数据库操作
        return null;
    }

    public void updatePersonalInformation(Staff information) {
    }

    public List<? extends Staff> getSalaryList(String username){
        //TODO 数据库操作
        return null;
    }
}
