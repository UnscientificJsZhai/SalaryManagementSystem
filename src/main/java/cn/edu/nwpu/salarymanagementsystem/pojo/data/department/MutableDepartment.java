package cn.edu.nwpu.salarymanagementsystem.pojo.data.department;

import cn.edu.nwpu.salarymanagementsystem.pojo.exception.DepartmentLevelException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 部门。<br/>
 * 表示部门的实现类。管理员可以操作其中的数据。
 *
 * @author UnscientficJsZhai
 */
public final class MutableDepartment extends Department {

    private final long id;

    private final long parentDepartment;

    /**
     * 表示层级。层级1时parentDepartment可为空。
     */
    private final int level;

    /**
     * 构造方法。
     *
     * @param id               部门id。这是它的主键。
     * @param name             部门名称。
     * @param parentDepartment 父部门名称。
     * @param level            层级。如果层级为1则父部门名称可以为-1。
     */
    public MutableDepartment(long id, @NotNull String name, long parentDepartment, int level) {
        super(name);
        if ((parentDepartment == -1) == (level != 1)) {
            throw new DepartmentLevelException(level);
        }
        this.id = id;
        this.parentDepartment = parentDepartment;
        this.level = level;
    }

    public long getParentDepartment() {
        return parentDepartment;
    }

    public int getLevel() {
        return level;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MutableDepartment{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", parentDepartment='" + parentDepartment + '\'' +
                ", level=" + level +
                '}';
    }
}