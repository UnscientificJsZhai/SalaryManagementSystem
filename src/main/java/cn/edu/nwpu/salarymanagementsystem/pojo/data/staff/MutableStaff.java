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
        if (department == null) {
            this.department = null;
        } else {
            this.department = department.getId();
        }
    }

    public void setUsername(long username) {
        this.id = username;
    }

    /**
     * 默认构造函数，全部数据。
     *
     * @param id          用户名。
     * @param name        真实姓名
     * @param phoneNumber 手机号。
     * @param email       电子邮箱。
     * @param department  部门。可以为空，空表示所属部门刚被删除。
     */
    public MutableStaff(long id, @NotNull String name, @NotNull String phoneNumber, @NotNull String email, @Nullable Long department) {
        super(id, name, phoneNumber, email, department);
    }
}
