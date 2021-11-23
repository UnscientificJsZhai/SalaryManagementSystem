package cn.edu.nwpu.salarymanagementsystem.pojo.data.salary;

/**
 * 薪水。
 * 表示薪水的数据类。是基类的实现。可供管理员进行修改。
 *
 * @author UnscientificJsZhai
 * @version 2
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

    public MutableSalary(int month, double postWage, double meritPay, double seniorityPay, double subsidy, boolean paid) {
        super(month, postWage, meritPay, seniorityPay, subsidy, paid);
    }
}
