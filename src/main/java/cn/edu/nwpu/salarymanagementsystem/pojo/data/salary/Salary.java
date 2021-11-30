package cn.edu.nwpu.salarymanagementsystem.pojo.data.salary;

/**
 * 薪水。<br/>
 * 表示薪水的数据类。可供一般用户访问。但是不允许进行修改操作。
 *
 * @author UnscientificJsZhai
 * @version 2
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
}
