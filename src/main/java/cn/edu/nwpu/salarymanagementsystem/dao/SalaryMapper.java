package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.MutableSalary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.Salary;

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
     */
    void addSalary(Salary salary, String username);

    /**
     * 删除这个员工的所有薪水记录。
     *
     * @param username 员工用户名。
     */
    void deleteSalaryAll(String username);

    /**
     * 删除员工指定月份的薪水记录。
     *
     * @param username 员工用户名。
     * @param month    指定的月份 1-12。
     */
    void deleteSalaryByMonth(String username, int month);

    /**
     * 更改指定月份的薪水记录。 <br/>
     * 不能更改用户名和月份信息，要更改请删除新增
     *
     * @param salary   指定月的薪水记录。
     * @param username 员工用户名。
     */
    void alterSalary(Salary salary, String username);

    /**
     * 查询指定员工的所有新书记录。
     *
     * @param username 员工用户名。
     * @return 返回薪酬列表。
     */
    List<MutableSalary> queryAll(String username);

    /**
     * 返回员工指定月份的薪水记录。
     *
     * @param username 员工用户名。
     * @param month    指定月份。
     * @return 薪水数据类。
     */
    MutableSalary queryByMonth(String username, int month);
}
