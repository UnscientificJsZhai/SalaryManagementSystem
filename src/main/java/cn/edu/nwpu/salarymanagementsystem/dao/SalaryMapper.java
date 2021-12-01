package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.MutableSalary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.Salary;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * 查询薪水信息的Dao接口。
 *
 * @author mikasa
 */
public interface SalaryMapper {

    /**
     * 给指定的员工添加某个月的薪水记录。每个选项都不能为空。
     *
     * @param salary   薪水数据列。
     * @param username 员工的用户名。
     * @throws SQLIntegrityConstraintViolationException 当月份重复的时候或者用户名不存在的时候
     */
    void addSalary(@Param("salary") Salary salary, @Param("username") String username) throws SQLIntegrityConstraintViolationException;

    /**
     * 删除这个员工的所有薪水记录。
     *
     * @param username 员工用户名。不存在不会有任何改变
     */
    void deleteSalaryAll(String username);

    /**
     * 删除员工指定月份的薪水记录。
     *
     * @param username 员工用户名， 不存在不会有任何改变。
     * @param month    指定的月份，不存在不会有任何改变。
     */
    void deleteSalaryByMonth(@Param("username") String username, @Param("month") int month);

    /**
     * 更改指定用户指定月份的薪水记录。 <br/>
     * 不能更改用户名和月份信息，要更改请删除新增。<br/>
     * 若不存在指定行则不会有任何改变
     *
     * @param salary   指定月的薪水记录。数据类中需要存入数据库的属性段不能为空！
     * @param username 员工用户名。
     */
    void alterSalary(@Param("salary") Salary salary, @Param("username") String username);

    /**
     * 查询指定员工的所有薪水记录。
     *
     * @param username 员工用户名。
     * @return 若成功返回薪酬列表。若没有满足的返回size = 0 的列表
     */
    List<MutableSalary> queryAll(String username);

    /**
     * 返回员工指定月份的薪水记录。
     *
     * @param username 员工用户名。
     * @param month    指定月份。
     * @return 若成功薪水数据类。若失败返回null
     */
    MutableSalary queryByMonth(@Param("username") String username, @Param("month") int month);
}
