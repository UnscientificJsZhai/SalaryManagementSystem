package cn.edu.nwpu.salarymanagementsystem.service;

import cn.edu.nwpu.salarymanagementsystem.dao.SalaryMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.StaffMapper;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.Salary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    public void setStaffMapper(StaffMapper staffMapper) {
        this.staffMapper = staffMapper;
    }

    @Autowired
    public void setSalaryMapper(SalaryMapper salaryMapper) {
        this.salaryMapper = salaryMapper;
    }

    /**
     * 登录，进行身份验证。
     *
     * @param username 用户名。
     * @param password 密码。
     * @return 是否登录成功。如果是，则返回true。
     */
    public boolean login(String username, String password) {
        return staffMapper.login(username, password) != null;
    }

    /**
     * 获取用户个人信息。
     *
     * @param username 用户名。
     * @return 用户个人信息。
     */
    public Staff getPersonalInformation(String username) {
        return staffMapper.queryByUserName(username);
    }

    /**
     * 更新用户个人信息。
     *
     * @param information 修改后的用户个人信息的数据类。
     */
    public void updatePersonalInformation(Staff information) {
        final HashMap<String, String> informationMap = new HashMap<>();
        informationMap.put(StaffMapper.EMAIL, information.getEmail());
        informationMap.put(StaffMapper.PHONE_NUMBER, information.getPhoneNumber());
        informationMap.put(StaffMapper.NAME, information.getName());
        staffMapper.alterProfile(informationMap);
    }

    /**
     * 更新密码。
     *
     * @param newPassword 新密码，要求已经经过验证确认两次输入的值相同。
     */
    public void updatePassword(String newPassword) {
        final HashMap<String, String> informationMap = new HashMap<>();
        informationMap.put(StaffMapper.PASSWORD, newPassword);
        staffMapper.alterProfile(informationMap);
    }

    /**
     * 查询所有工资信息。
     *
     * @param username 用户名。
     * @return 工资信息。
     */
    public List<? extends Salary> getSalaryList(String username) {
        return salaryMapper.queryAll(username);
    }
}
