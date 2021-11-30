package cn.edu.nwpu.salarymanagementsystem.pojo.data.department;

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
    public MutableDepartment(String name, String parentDepartment, int level) {
        super(name);
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