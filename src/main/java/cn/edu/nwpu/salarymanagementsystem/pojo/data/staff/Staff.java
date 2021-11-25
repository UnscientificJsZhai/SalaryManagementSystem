package cn.edu.nwpu.salarymanagementsystem.pojo.data.staff;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.Department;

import java.util.HashMap;
import java.util.Map;

/**
 * 员工。
 * 表示员工的数据类，可供员工在个人信息界面中维护自己的个人信息。但是对于修改有一定的限制。
 *
 * @author UnscientificJsZhai
 * @version 3
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
    protected String department;

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

    public String getDepartment() {
        return department;
    }

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

    /**
     * 默认构造方法。
     *
     * @param username    用户名。
     * @param name        真实姓名。
     * @param phoneNumber 手机号。
     * @param email       邮箱。
     * @param department  部门。
     */
    public Staff(String username, String name, String phoneNumber, String email, Department department) {
        this.username = username;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.department = department.getName();
    }

    /**
     * 生成用于数据库操作的Map对象。
     *
     * @return 一个HashMap。
     */
    public Map<String, Object> generateMap() {
        final HashMap<String, Object> map = new HashMap<>();
        map.put("username", this.username);
        map.put("truename", this.name);
        map.put("phone", this.phoneNumber);
        map.put("email", this.email);
        map.put("department", this.department);
        return map;
    }
}
