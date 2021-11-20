package cn.edu.nwpu.salarymanagementsystem.pojo.data.department;

/**
 * 部门。
 * 表示部门的数据类，用于在员工中查看部门信息。
 *
 * @author UnscientificJsZhai
 * @version 1
 */
public abstract class Department {

    /**
     * 部门名称。
     */
    protected String name;

    public String getName() {
        return name;
    }
}
