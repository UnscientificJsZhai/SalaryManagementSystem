package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;

import java.util.List;
import java.util.Map;

public interface StaffMapper {

    /**
     * 添加一个用户，应该有如下的键值对。
     * username password truename phone email departmentId
     * 键值对的key应该如上面所示
     * @param user 保存这些信息的键值对
     */
    void addStaff(Map<String,Object> user);

    /**
     * 删除一个员工，并根据他的id删除他的薪水记录
     * @param staffId 要删除的员工
     */
    void deleteStaff(int staffId);

    /**
     * 删除指定部门的所有员工
     * @param departmentId 部门id
     */
    void deleteStaffByDepartment(int departmentId);

    /**
     * 修改一个员工，应该有如下的键值对
     * id
     * username password truename phone email departmentId
     * @param staff 保存这些信息的键值对
     */
    void alterStaff(Map<String,Object> staff);

    /**
     * 查询所有员工
     * @return 所有员工列表
     */
    List<? extends Staff> queryAll();

    /**
     * 查询指定员工
     * @return 员工数据类
     */
    Staff queryById(int staffId);
}
