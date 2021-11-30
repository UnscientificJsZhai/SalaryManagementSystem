package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

/**
 *
 */
public interface StaffMapper {

    /**
     * 添加一个用户。<br/>
     * 用户名不能重复！
     *
     * @param staff    员工
     * @param password 密码
     * @throws SQLIntegrityConstraintViolationException 当主键重复时抛出此异常。
     */
    void addStaff(@Param("staff") Staff staff, @Param("password") String password) throws SQLIntegrityConstraintViolationException;

    /**
     * 删除一个员工，并删除他的薪水记录。<br/>
     * 数据库自动完成，不需要单独再调用!
     *
     * @param username 要删除的员工的姓名。
     */
    void deleteStaff(String username);

    /**
     * 删除指定部门的所有员工。薪水会连带删除
     *
     * @param name 部门名字。
     */
    void deleteStaffByDepartment(String name);

    /**
     * 修改一个员工的所属。<br/>
     * 应该是存在部门才行！<br/>
     *
     *
     * @param name 新的部门的名字。
     */
    //TODO 异常添加
    void alterDepartment(String name);

    /**
     * 查询所有员工。
     *
     * @return 所有员工列表。
     */
    List<MutableStaff> queryAll();

    /**
     * 根据用户名查询指定员工。
     *
     * @param username 员工用户名
     * @return 员工数据类。
     */
    MutableStaff queryByUserName(String username);

    /**
     * 根据真实姓名查询指定员工。
     *
     * @param truename 员工真实姓名
     * @return 员工数据类。
     */
    MutableStaff queryByTrueName(String truename);

    /**
     * 根据部门名字查询指定员工。
     *
     * @param name 部门名字
     * @return 员工数据类。
     */
    MutableStaff queryByDepartment(String name);

    /**
     * 返回是否有此用户。
     *
     * @param username 用户
     * @param password 密码
     * @return 若匹配返回该对象，若不匹配则返回null
     */
    MutableStaff login(@Param("username") String username, @Param("password") String password);

    /**
     * 修改个人信息 <br/>
     * 包括： 密码 真实姓名 电话（位数检验） 邮件（格式检验）<br/>
     *
     * @param profile 要更改的信息，以键值对进行体现
     */
    void alterProfile(Map<String, String> profile);

    /**
     * 修改个人信息的Map中，密码对应的Key。
     */
    String PASSWORD = "password";

    /**
     * 修改个人信息的Map中，真实姓名对应的Key。
     */
    String NAME = "name";

    /**
     * 修改个人信息的Map中，电话对应的Key。
     */
    String PHONE_NUMBER = "phone";

    /**
     * 修改个人信息的Map中，邮件对应的Key。
     */
    String EMAIL = "email";
}
