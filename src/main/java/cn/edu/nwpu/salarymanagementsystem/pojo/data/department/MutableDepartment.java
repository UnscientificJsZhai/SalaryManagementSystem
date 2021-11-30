package cn.edu.nwpu.salarymanagementsystem.pojo.data.department;

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
    private final int level;

    /**
     * 构造方法。
     *
     * @param name 部门名称。
     */
    public MutableDepartment(String name, String parentDepartment, List<String> childDepartments, int level) {
        super(name);
        this.parentDepartment = parentDepartment;
        this.childDepartments = new ArrayList<>(childDepartments);
        this.level = level;
    }

    public String getParentDepartment() {
        return parentDepartment;
    }

    public List<String> getChildDepartments() {
        return childDepartments;
    }

    public int getLevel() {
        return level;
    }
}