package cn.edu.nwpu.salarymanagementsystem.pojo.data.staff;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.Department;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.MutableSalary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.Salary;

import java.util.ArrayList;
import java.util.List;

/**
 * 员工。
 * 表示员工的数据类，可供管理员管理员工信息与设定薪水列表
 *
 * @author UnscientificJsZhai
 * @version 1
 */
final public class MutableStaff extends Staff {

    /**
     * 工资列表。使用{@link MutableStaff#getMutableSalaryList()}方法编辑这个列表。
     */
    private final ArrayList<MutableSalary> salaryList = new ArrayList<>();

    /**
     * 获取员工可供管理员修改的薪水列表。
     * 员工不能调用此方法。
     *
     * @return 薪水列表。
     */
    public ArrayList<MutableSalary> getMutableSalaryList() {
        return salaryList;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public List<? extends Salary> getSalaryList() {
        return salaryList;
    }
}
