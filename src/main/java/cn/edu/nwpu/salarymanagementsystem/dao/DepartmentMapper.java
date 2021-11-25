package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.Department;

import java.util.List;

public interface DepartmentMapper {

    /**
     * 添加一个新的部门
     *
     * @param name     部门名
     * @param parentId 上级部门的ID，若没有则为null
     * @param floor    部门层级 0-无穷
     */
    void addDepartment(String name, int parentId, int floor);

    /**
     * 删除这个部门的所有一级子部门
     * 条件： 子部门是叶子节点，且子部门没有员工的情况下
     *
     * @param departmentId 部门Id
     */
    void deleteAll(int departmentId);

    /**
     * 删除指定部门
     * 条件：部门是叶子节点，且部门没有员工
     *
     * @param departmentId 部门id
     */
    void deleteById(int departmentId);

    /**
     * 修改一个部门
     * 条件 上级部门的层级必须比此部门高。
     * 例子： 层级1的上级部门只能为0了
     *
     * @param name     新的名字
     * @param parentId 上级部门
     * @param floor    层级
     */
    void alterDepartment(String name, int parentId, int floor);

    /**
     * 返回所有的部门
     *
     * @return 部门按照层级排序
     */
    List<? extends Department> queryAll();

    /**
     * 返回指定的部门
     *
     * @param departmentId 指定的部门id
     * @return 部门数据类
     */
    Department queryById(int departmentId);

    /**
     * 查询该部门的所有一级下属部门
     *
     * @param parentId 上级部门
     * @return 子部门list
     */
    List<? extends Department> queryChildAll(int parentId);
}
