package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.MutableDepartment;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * 查询部门信息的Dao接口。
 *
 * @author mikasa
 */
public interface DepartmentMapper {

    /**
     * 添加一个新的部门 <br/>
     * 请注意几个逻辑问题，需要做判断后才能调用此方法：1.parent部门必须存在 2.保证前述条件下，level必须 = parent.level + 1
     *
     * @param department 部门数据类。要进入数据库的属性字段不能为空！
     * @throws SQLIntegrityConstraintViolationException 当部门名称重复的时候，会抛出此异常。
     */
    void addDepartment(@Param("department") MutableDepartment department) throws SQLIntegrityConstraintViolationException;

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

    /**
     * 顶级部门的父部门。以此值代替null。<br/>
     * 保留部门名，任何部门不能与它重名。
     */
    String ROOT_DEPARTMENT = "root";
}
