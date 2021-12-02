package cn.edu.nwpu.salarymanagementsystem.pojo.data.department;

import cn.edu.nwpu.salarymanagementsystem.dao.DepartmentMapper;
import cn.edu.nwpu.salarymanagementsystem.pojo.exception.DepartmentLevelException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * 部门。<br/>
 * 表示部门的实现类。管理员可以操作其中的数据。
 *
 * @author UnscientficJsZhai
 */
public final class MutableDepartment extends Department {

    /**
     * 最上层层次的等级。
     */
    public static final int TOP_LEVEL = 1;

    /**
     * 父部门。可能为空。
     */
    private final Long parentDepartment;

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
     * @param level            层级。如果层级为1则父部门可以为null。
     */
    public MutableDepartment(long id, @NotNull String name, @Nullable Long parentDepartment, int level) {
        super(name);
        if ((parentDepartment == null) == (level != TOP_LEVEL)) {
            throw new DepartmentLevelException(level);
        }
        this.id = id;
        this.parentDepartment = parentDepartment;
        this.level = level;
    }

    @Nullable
    public Long getParentDepartment() {
        return parentDepartment;
    }

    public int getLevel() {
        return level;
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

    /**
     * 生成用于操作数据库的Map。
     *
     * @return 包含了当前部门信息的Map对象。
     */
    public Map<String, Object> generateMap() {
        final HashMap<String, Object> map = new HashMap<>();

        map.put(DepartmentMapper.ID, this.id);
        map.put(DepartmentMapper.NAME, this.name);
        if (this.level == TOP_LEVEL) {
            map.put(DepartmentMapper.PARENT, null);
        } else {
            map.put(DepartmentMapper.PARENT, this.parentDepartment);
        }
        map.put(DepartmentMapper.LEVEL, this.level);

        return map;
    }
}