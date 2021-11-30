package cn.edu.nwpu.salarymanagementsystem.pojo.data.staff;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * 员工。<br/>
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

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public void setPhoneNumber(@NotNull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    /**
     * 默认构造方法。
     *
     * @param username    用户名。
     * @param name        真实姓名。
     * @param phoneNumber 手机号。
     * @param email       邮箱。
     * @param department  部门名字。可以为空。空表示当前员工没有所属部门，可能是由于所属部门刚被删除。
     */
    public Staff(@NotNull String username, @NotNull String name, @NotNull String phoneNumber, @NotNull String email, @Nullable String department) {
        this.username = username;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.department = department;
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

    @Override
    public String toString() {
        return "Staff{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
