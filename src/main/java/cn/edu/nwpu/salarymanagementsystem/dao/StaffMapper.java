package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

/**
 * 查询员工信息的Dao接口。
 *
 * @author mikasa
 */
public interface StaffMapper {

    /**
     * 员工工号
     */
    String ID = "staffId";

    /**
     * 员工密码
     */
    String PASSWORD = "password";

    /**
     * 员工姓名
     */
    String NAME = "staffName";

    /**
     * 员工电话
     */
    String PHONE = "phone";

    /**
     * 员工邮件
     */
    String EMAIL = "email";

    /**
     * 员工所属部门编号
     */
    String DEPARTMENT_ID = "departmentId";

    /**
     * 添加一个用户。<br/>
     *
     * @param map 员工数据类 包括：staff_id，password，staff_name，phone，email，department_id <br/>
     *            其中 phone email departmentid 可以为null
     * @throws SQLIntegrityConstraintViolationException 当用户名重复时或者外键不存在的时候
     */
    void addStaff(Map<String, Object> map) throws SQLIntegrityConstraintViolationException;

    /**
     * 删除一个员工，并自动删除他的薪水记录。数据库自动完成，不需要单独再调用! <br/>
     *
     * @param staffId 要删除的员工的id。若不存在不会有任何改变
     */
    void deleteById(long staffId);

    /**
     * 删除指定部门的所有员工。薪水会连带删除
     *
     * @param departmentId 部门id。 若不存在不会有任何改变
     */
    void deleteByDepartment(long departmentId);

    /**
     * 修改一个员工的所属。应该是存在部门才行！<br/>
     *
     * @param staffId      需要更改的用户 若不存在不会有任何改变。
     * @param departmentId 新的部门的Id
     * @throws SQLIntegrityConstraintViolationException 更改的部门不存在
     */
    void alterDepartment(@Param("departmentId") long departmentId, @Param("staffId") long staffId) throws SQLIntegrityConstraintViolationException;

    /**
     * 查询所有员工。
     *
     * @return 所有员工列表。若没有符合的成员，则list的size为0
     */
    List<MutableStaff> queryAll();

    /**
     * 通过ID查找员工
     *
     * @param staffId 员工id
     * @return 若成功返回员工数据类 若失败返回NULL
     */
    MutableStaff queryById(long staffId);

    /**
     * 根据用户名查询指定员工。
     *
     * @param staffName 员工姓名
     * @return 员工数据类。若没有返回size = 0
     */
    List<MutableStaff> queryByName(String staffName);

    /**
     * 根据部门名字查询指定员工。
     *
     * @param departmentName 部门名字
     * @return 员工数据类。若没有返回size = 0
     */
    List<MutableStaff> queryByDepartmentName(String departmentName);

    /**
     * 根据部门名字查询指定员工。
     *
     * @param departmentId 部门id
     * @return 员工数据类。若没有返回size = 0
     */
    List<MutableStaff> queryByDepartmentId(String departmentId);

    /**
     * 返回是否有此用户。
     *
     * @param staffId  用户id
     * @param password 密码
     * @return 若匹配返回该对象，若不匹配则返回null
     */
    MutableStaff login(@Param("staffId") long staffId, @Param("password") String password);

    /**
     * 修改个人信息 <br/>
     * 可选：密码 真实姓名 电话（位数检验） 邮件（格式检验） <br/>
     *
     * @param profile 要更改的信息，以键值对进行体现
     * @param staffId 需要传id来确认更改者是谁
     */
    void alterProfile(@Param("profile") Map<String, String> profile, @Param("staffId") long staffId);
}
