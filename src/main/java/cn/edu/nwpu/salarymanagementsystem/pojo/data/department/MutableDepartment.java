package cn.edu.nwpu.salarymanagementsystem.pojo.data.department;

import cn.edu.nwpu.salarymanagementsystem.pojo.exception.DepartmentLevelException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 部门。<br/>
 * 表示部门的实现类。管理员可以操作其中的数据。
 *
 * @author UnscientficJsZhai
 * @version 2
 */
public final class MutableDepartment extends Department {

    private final String parentDepartment;

    /**
     * 表示层级。层级1时parentDepartment可为空。
     */
    private final int level;

    /**
     * 构造方法。
     *
     * @param name 部门名称。
     */
    public MutableDepartment(@NotNull String name, @Nullable String parentDepartment, int level) {
        super(name);
        if ((parentDepartment == null) == (level != 1)) {
            throw new DepartmentLevelException(level);
        }
        this.parentDepartment = parentDepartment;
        this.level = level;
    }

    public String getParentDepartment() {
        return parentDepartment;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "MutableDepartment{" +
                "name='" + name + '\'' +
                ", parentDepartment='" + parentDepartment + '\'' +
                ", level=" + level +
                '}';
    }

}