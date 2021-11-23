package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff;
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
     * @param staff 要删除的员工
     */
    void deleteStaff(Staff staff);

    /**
     * 修改一个员工，应该有如下的键值对
     * username password truename phone email departmentId
     * @param staff 保存这些信息的键值对
     */
    void alterStaff(Map<String,Object> staff);

    List<MutableStaff> queryAll();
}
