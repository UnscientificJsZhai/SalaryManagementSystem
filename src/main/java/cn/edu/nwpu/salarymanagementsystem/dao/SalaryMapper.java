package cn.edu.nwpu.salarymanagementsystem.dao;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.MutableSalary;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

/**
 * 查询薪水信息的Dao接口。
 *
 * @author mikasa
 */
public interface SalaryMapper {

    /**
     * 员工工号
     */
    String ID = "staffId";

    /**
     * 月份
     */
    String MONTH = "month";

    /**
     * 薪水种类1
     */
    String POST_WAGE = "postWage";

    /**
     * 薪水种类2
     */
    String MERIT_PAY = "meritPay";

    /**
     * 薪水种类3
     */
    String SENIORITY_PAY = "seniorityPay";

    /**
     * 薪水种类4
     */
    String SUBSIDY = "subsidy";

    /**
     * 是否支付给员工
     */
    String PAID = "paid";

    /**
     * 给指定的员工添加某个月的薪水记录。每个选项都不能为空。
     *
     * @param map 薪水数据类。 包括：staff_id，month，post_wage，merit_pay，seniority_pay，subsidy，paid。
     * @throws SQLIntegrityConstraintViolationException 当月份重复的时候或者用户id不存在的时候
     */
    void addSalary(Map<String, Object> map) throws SQLIntegrityConstraintViolationException;

    /**
     * 删除这个员工的所有薪水记录。
     *
     * @param staffId 员工id。不存在不会有任何改变
     */
    void deleteById(long staffId);

    /**
     * 删除员工指定月份的薪水记录。
     *
     * @param staffId 员工id， 不存在不会有任何改变。
     * @param month   指定的月份，不存在不会有任何改变。
     */
    void deleteByMonth(@Param("staffId") long staffId, @Param("month") int month);

    /**
     * 更改指定用户指定月份的薪水记录。 <br/>
     * 不能更改用户名和月份信息，要更改请删除新增。<br/>
     * 若不存在指定行则不会有任何改变
     *
     * @param map 需要更改的信息： 包括：post_wage，merit_pay，seniority_pay，subsidy，paid。<br/>
     *            提示:上述的为可选项。
     */
    void alterSalary(Map<String, Object> map);

    /**
     * 查询指定员工的所有薪水记录。
     *
     * @param staffId 员工id
     * @return 若成功返回薪酬列表。若没有满足的返回size = 0 的列表
     */
    List<MutableSalary> queryById(long staffId);

    /**
     * 返回员工指定月份的薪水记录。
     *
     * @param staffId 员工id。
     * @param month   指定月份。
     * @return 若成功薪水数据类。若失败返回null
     */
    MutableSalary queryByMonth(@Param("staffId") long staffId, @Param("month") int month);
}
