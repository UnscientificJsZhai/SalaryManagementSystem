package cn.edu.nwpu.salarymanagementsystem.pojo.data.department;

import java.util.Objects;

/**
 * 部门。<br/>
 * 表示部门的数据类，用于在员工中查看部门信息。<br/>
 * 部门是不允许是重名的。
 *
 * @author UnscientificJsZhai
 * @version 2
 */
public abstract class Department {

    /**
     * 部门名称。
     */
    protected String name;

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * 默认构造方法。
     *
     * @param name 部门名称。
     */
    public Department(String name) {
        this.name = name;
    }
}
