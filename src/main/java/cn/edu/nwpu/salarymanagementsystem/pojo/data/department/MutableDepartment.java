package cn.edu.nwpu.salarymanagementsystem.pojo.data.department;

import org.springframework.lang.Nullable;

import java.util.List;

/**
 * 部门。
 * 表示部门的实现类。管理员可以操作其中的数据。
 *
 * @author UnscientficJsZhai
 * @version 1
 */
public final class MutableDepartment extends Department {

    /**
     * 通过部门名称查找部门对象。
     *
     * @param name 部门名称。
     * @return 部门对象。
     */
    @Nullable
    public static Department findDepartmentByName(String name) {
        return DepartmentHolder.INSTANCE.getDepartment(name);
    }

    /**
     * 构造方法。不要通过此构造方法实例化部门信息。
     *
     * @param name 部门名称。
     */
    public MutableDepartment(String name) {
        super(name);
    }

    /**
     * 获取上级部门。
     *
     * @return 部门。
     */
    public Department getParentDepartment() {
        //TODO 等待数据库实现
        return null;
    }

    /**
     * 获取所有下级部门。
     *
     * @return 下级部门集合。
     */
    public List<? extends Department> getChildDepartments() {
        //TODO 等待数据库实现
        return null;
    }

    /**
     * 设置上级部门。
     *
     * @param department 要设置的上级部门，如果为null，则清除上级部门信息。
     */
    public void setParentDepartment(@Nullable Department department) {
        //TODO 等待数据库实现
    }

    /**
     * 设置部门名称。
     *
     * @param name 新的部门名称。
     */
    public synchronized void setDepartmentName(String name) {
        final String oldName = this.name;
        this.name = name;
        DepartmentHolder.INSTANCE.updateDepartment(oldName, this);
        //TODO 数据库更新
    }
}
