package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.MutableDepartment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 查询部门信息的Dao接口。
 *
 * @author mikasa
 */
public interface DepartmentMapper {

    /**
     * 添加一个新的部门
     *
     * @param parent     父部门名。必须存在！
     * @param department 部门数据类。
     */
    void addDepartment(@Param("department") MutableDepartment department, @Param("parent") String parent);

    /**
     * 删除指定部门。<br/>
     * 条件：部门是叶子节点，且部门没有员工。
     *
     * @param name 部门名字。
     */
    void deleteByName(String name);

    /**
     * 修改部门的名字。
     *
     * @param name 新的名字。
     */
    void alterName(@Param("newName") String newName, @Param("name") String name);

    /**
     * 查询所有部门。
     *
     * @return 包含所有部门信息的列表。
     */
    List<MutableDepartment> queryAll();

    /**
     * 通过部门名称查询部门信息。
     *
     * @param name 部门名称。
     * @return 查询到的部门信息。如果输入的部门名查询不到结果，则返回null。
     */
    MutableDepartment queryByName(String name);
}
