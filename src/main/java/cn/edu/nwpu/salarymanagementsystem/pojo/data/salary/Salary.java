package cn.edu.nwpu.salarymanagementsystem.pojo.data.salary;

import cn.edu.nwpu.salarymanagementsystem.dao.SalaryMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * 薪水。<br/>
 * 表示薪水的数据类。可供一般用户访问。但是不允许进行修改操作。
 *
 * @author UnscientificJsZhai
 */
public abstract class Salary {

    /**
     * 薪水对应的月份。
     */
    protected int month;

    /**
     * 岗位工资。
     */
    protected double postWage;

    /**
     * 绩效工资。
     */
    protected double meritPay;

    /**
     * 工龄工资。
     */
    protected double seniorityPay;

    /**
     * 补贴。
     */
    protected double subsidy;

    /**
     * 是否已发放工资。
     */
    protected boolean paid;

    public int getMonth() {
        return month;
    }

    public double getPostWage() {
        return postWage;
    }

    public double getMeritPay() {
        return meritPay;
    }

    public double getSeniorityPay() {
        return seniorityPay;
    }

    public double getSubsidy() {
        return subsidy;
    }

    public boolean isPaid() {
        return paid;
    }

    /**
     * 默认构造方法。
     *
     * @param month        薪水对应的月份。
     * @param postWage     岗位工资。
     * @param meritPay     绩效工资。
     * @param seniorityPay 工龄工资。
     * @param subsidy      补贴。
     * @param paid         是否已发放工资。
     */
    public Salary(int month, double postWage, double meritPay, double seniorityPay, double subsidy, boolean paid) {
        this.month = month;
        this.postWage = postWage;
        this.meritPay = meritPay;
        this.seniorityPay = seniorityPay;
        this.subsidy = subsidy;
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "month=" + month +
                ", postWage=" + postWage +
                ", meritPay=" + meritPay +
                ", seniorityPay=" + seniorityPay +
                ", subsidy=" + subsidy +
                ", paid=" + paid +
                '}';
    }

    /**
     * 生成用于数据库操作的Map对象。
     *
     * @param staffId 要操作薪水信息的用户。
     * @return 包含必须信息的Map。
     */
    public Map<String, Object>  generateMap(long staffId) {
        final HashMap<String, Object> map = new HashMap<>();

        map.put(SalaryMapper.ID, staffId);
        map.put(SalaryMapper.MONTH, this.month);
        map.put(SalaryMapper.POST_WAGE, this.postWage);
        map.put(SalaryMapper.MERIT_PAY, this.meritPay);
        map.put(SalaryMapper.SENIORITY_PAY, this.seniorityPay);
        map.put(SalaryMapper.SUBSIDY, this.subsidy);
        map.put(SalaryMapper.PAID, this.paid);

        return map;
    }

    /**
     * 计算个人所得税。
     *
     * @return 计算得到得到的个人所得税。
     */
    public double tex() {
        //TODO
        return 0.0;
    }

    /**
     * 判断薪水信息是否合法。<br/>
     * 月份必须大于0。每部分工资必须大于等于0。
     *
     * @return 薪水信息的合法性。如果合法返回true，否则false。
     */
    public boolean isLegal() {
        return month > 0 && postWage >= 0 && meritPay >= 0 && seniorityPay >= 0 && subsidy >= 0;
    }
}
