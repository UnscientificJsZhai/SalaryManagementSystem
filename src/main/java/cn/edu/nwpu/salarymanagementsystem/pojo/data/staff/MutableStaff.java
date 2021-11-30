package cn.edu.nwpu.salarymanagementsystem.pojo.data.staff;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.Department;

/**
 * 员工。<br/>
 * 表示员工的数据类，可供管理员管理员工信息与设定薪水列表
 *
 * @author UnscientificJsZhai
 * @version 3
 */
final public class MutableStaff extends Staff {

    public void setDepartment(Department department) {
        this.department = department.getName();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 默认构造函数，全部数据。
     *
     * @param username    用户名。
     * @param name        真实姓名
     * @param phoneNumber 手机号。
     * @param email       电子邮箱。
     * @param department  部门。
     */
    public MutableStaff(String username, String name, String phoneNumber, String email, Department department) {
        super(username, name, phoneNumber, email, department);
    }
}
