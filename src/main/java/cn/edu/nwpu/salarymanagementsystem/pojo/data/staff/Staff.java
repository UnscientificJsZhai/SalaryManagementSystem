package cn.edu.nwpu.salarymanagementsystem.pojo.data.staff;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.Department;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.Salary;

import java.util.List;

/**
 * 员工。
 * 表示员工的数据类，可供员工在个人信息界面中维护自己的个人信息。但是对于修改有一定的限制。
 *
 * @author UnscientificJsZhai
 * @version 1
 */
public abstract class Staff {

    /**
     * 用户名。
     */
    protected String username;

    /**
     * 真实姓名。
     */
    protected String name;

    /**
     * 手机号。
     */
    protected String phoneNumber;

    /**
     * 电子邮箱。
     */
    protected String email;

    /**
     * 单位。
     */
    protected Department department;

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Department getDepartment() {
        return department;
    }

    abstract public List<? extends Salary> getSalaryList();

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
