package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.MutableDepartment;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

/**
 * 查询部门信息的Dao接口。
 *
 * @author mikasa
 */
public interface DepartmentMapper {


    /**
     * 部门编号
     */
    String ID = "departmentId";

    /**
     * 部门名字
     */
    String NAME = "departmentName";

    /**
     * 该部门的上级部门编号
     */
    String PARENT = "parentId";

    /**
     * 部门层级
     */
    String LEVEL = "level";

    /**
     * 添加一个新的部门 <br/>
     * 请维护关于parent和level的逻辑关系，数据库无法识别此逻辑，请在添加之前判断。
     *
     * @param map 部门数据。 包括：departmentId departmentName parentId level <br/>
     *            其中parentId可以为null
     * @throws SQLIntegrityConstraintViolationException 当id重复或者外键不存在时候
     */
    void addDepartment(Map<String, Object> map) throws SQLIntegrityConstraintViolationException;

    /**
     * 删除指定部门。<br/>
     * 注意，其子部门会被连带删除，且员工此字段会变为null
     *
     * @param departmentId 部门id 若不存在则不会有任何改变
     *                     。
     */
    void deleteById(long departmentId);

    /**
     * 删除该部门的所有下级子部门。
     * 注意，其子部门的子部门会被连带删除，且员工此字段会变为null
     *
     * @param parentId 父亲部门id 若不存在不会有任何改变
     */
    void deleteByParent(long parentId);

    /**
     * 修改部门的名字。
     *
     * @param newName      新的名字。
     * @param departmentId 要更改的部门的Id 若不存在不会有任何改变
     */
    void alterName(@Param("newName") String newName, @Param("departmentId") long departmentId);

    /**
     * 查询所有部门。
     *
     * @return 包含所有部门信息的列表。 若没有满足的列表的size为0
     */
    List<MutableDepartment> queryAll();

    /**
     * 通过部门id查询部门信息。
     *
     * @param departmentId 部门id
     * @return 查询到的部门信息。如果输入的id查询不到结果，则返回null。
     */
    MutableDepartment queryById(long departmentId);

    /**
     * 通过名字查询部门
     *
     * @param departmentName 部门名字
     * @return 满足条件的部门信息的列表。 若没有满足的列表的size为0
     */
    List<MutableDepartment> queryByName(String departmentName);

    /**
     * 查询父亲部门的一级子部门
     *
     * @param departmentId 父亲部门id
     * @return 满足条件的部门信息的列表。 若没有满足的列表的size为0
     */
    List<MutableDepartment> queryByParent(long departmentId);

    /**
     * 查询该层级的所有部门
     *
     * @param level 部门层级
     * @return 满足条件的部门信息的列表。 若没有满足的列表的size为0
     */
    List<MutableDepartment> queryByLevel(int level);

}
