package cn.edu.nwpu.salarymanagementsystem.pojo.data.salary;

/**
 * 薪水。<br/>
 * 表示薪水的数据类。是基类的实现。可供管理员进行修改。
 *
 * @author UnscientificJsZhai
 */
final public class MutableSalary extends Salary {

    public void setMonth(int month) {
        this.month = month;
    }

    public void setPostWage(double postWage) {
        this.postWage = postWage;
    }

    public void setMeritPay(double meritPay) {
        this.meritPay = meritPay;
    }

    public void setSeniorityPay(double seniorityPay) {
        this.seniorityPay = seniorityPay;
    }

    public void setSubsidy(double subsidy) {
        this.subsidy = subsidy;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
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
    public MutableSalary(int month, double postWage, double meritPay, double seniorityPay, double subsidy, boolean paid) {
        super(month, postWage, meritPay, seniorityPay, subsidy, paid);
    }
}
