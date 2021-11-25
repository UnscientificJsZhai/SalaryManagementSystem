package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.Salary;

import java.util.List;

public interface SalaryMapper {

    /**
     * 给指定的员工添加某个月的薪水记录
     *
     * @param salary  薪水数据列
     * @param staffId 员工的Id
     */
    void addSalary(Salary salary, int staffId);

    /**
     * 删除这个员工的所有薪水记录
     *
     * @param staffId 员工ID
     */
    void deleteSalaryAll(int staffId);

    /**
     * 删除员工指定月份的薪水记录
     *
     * @param staffId 员工ID
     * @param month   指定的月份 1-12
     */
    void deleteSalaryByMonth(int staffId, int month);

    /**
     * 更改指定月份的薪水记录
     *
     * @param salary  指定月的薪水记录
     * @param staffId 员工id
     */
    void alterSalary(Salary salary, int staffId);

    /**
     * 查询指定员工的所有新书记录
     *
     * @param staffId 指定员工ID
     * @return 返回薪酬列表
     */
    List<? extends Salary> queryAll(int staffId);

    /**
     * 返回员工指定月份的薪水记录
     *
     * @param staffId 员工Id
     * @param month   指定月份
     * @return 薪水数据类
     */
    Salary queryByMonth(int staffId, int month);

}
