package cn.edu.nwpu.salarymanagementsystem.pojo.data.staff;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.Department;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 员工。<br/>
 * 表示员工的数据类，可供管理员管理员工信息与设定薪水列表
 *
 * @author UnscientificJsZhai
 */
final public class MutableStaff extends Staff {

    public void setDepartment(@Nullable Department department) {
        this.department = department.getName();
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    /**
     * 默认构造函数，全部数据。
     *
     * @param username    用户名。x
     * @param name        真实姓名
     * @param phoneNumber 手机号。
     * @param email       电子邮箱。
     * @param department  部门。可以为空，空表示所属部门刚被删除。
     */
    public MutableStaff(@NotNull String username, @NotNull String name, @NotNull String phoneNumber, @NotNull String email, @Nullable String department) {
        super(username, name, phoneNumber, email, department);
    }
}
