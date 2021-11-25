package cn.edu.nwpu.salarymanagementsystem.pojo.data.department;

import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门。
 * 表示部门的实现类。管理员可以操作其中的数据。
 *
 * @author UnscientficJsZhai
 * @version 2
 */
public final class MutableDepartment extends Department {

    private final String parentDepartment;
    private final ArrayList<String> childDepartments;

    /**
     * 构造方法。
     *
     * @param name 部门名称。
     */
    public MutableDepartment(String name, String parentDepartment, List<String> childDepartments) {
        super(name);
        this.parentDepartment = parentDepartment;
        this.childDepartments = new ArrayList<>(childDepartments);
    }

    public String getParentDepartment() {
        return parentDepartment;
    }

    public List<String> getChildDepartments() {
        return childDepartments;
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
        //TODO 数据库更新
    }

    /**
     * 删除部门。
     *
     * @return 是否删除成功。
     */
    public synchronized boolean deleteDepartment() {
        //TODO 等待数据库实现。
        return false;
    }
}