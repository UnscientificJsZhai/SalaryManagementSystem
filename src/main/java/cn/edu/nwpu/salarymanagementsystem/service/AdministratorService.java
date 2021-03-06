package cn.edu.nwpu.salarymanagementsystem.service;

import cn.edu.nwpu.salarymanagementsystem.dao.AdministratorMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.DepartmentMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.SalaryMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.StaffMapper;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.administrator.Administrator;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.DepartmentTreeNode;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.MutableDepartment;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.MutableSalary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.Salary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff;
import cn.edu.nwpu.salarymanagementsystem.pojo.exception.DepartmentTreeException;
import cn.edu.nwpu.salarymanagementsystem.pojo.exception.DuplicatedUserException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员进行各种操作的服务。
 *
 * @author UnscientificJsZhai
 * @version 1
 */
@Service
public class AdministratorService {

    private AdministratorMapper administratorMapper;
    private DepartmentMapper departmentMapper;
    private SalaryMapper salaryMapper;
    private StaffMapper staffMapper;

    @Autowired
    public void setAdministratorMapper(AdministratorMapper administratorMapper) {
        this.administratorMapper = administratorMapper;
    }

    @Autowired
    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Autowired
    public void setSalaryMapper(SalaryMapper salaryMapper) {
        this.salaryMapper = salaryMapper;
    }

    @Autowired
    public void setStaffMapper(StaffMapper staffMapper) {
        this.staffMapper = staffMapper;
    }

    /**
     * 登录，进行身份验证。
     *
     * @param id       用户名。
     * @param password 密码。
     * @return 是否登录成功。如果是，则返回true。
     */
    public boolean login(long id, @NotNull String password) {
        return administratorMapper.login(id, password) != null;
    }

    public Administrator getAdministratorInfo(long id, String password) {
        return administratorMapper.login(id, password);
    }

    /**
     * 添加员工。
     *
     * @param staff    新的员工信息。
     * @param password 初始密码。
     * @throws DuplicatedUserException 如果新员工用户名和已经存在的员工用户名重复则抛出此异常。
     */
    public void addStaff(@NotNull MutableStaff staff, @NotNull String password) throws DuplicatedUserException {
        try {
            staffMapper.addStaff(staff.generateMap(password));
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new DuplicatedUserException(staff.getId(), e);
        }
    }

    /**
     * 删除员工。
     *
     * @param staff 要删除的员工的id。
     */
    public void deleteStaff(long staff) {
        staffMapper.deleteById(staff);
    }

    /**
     * 更改一个员工的部门。
     *
     * @param staff      要更改的员工的id。
     * @param department 所属的新部门的id。
     * @throws SQLIntegrityConstraintViolationException 如果新部门不存在则抛出此异常。
     */
    public void updateStaffDepartment(long staff, long department) throws SQLIntegrityConstraintViolationException {
        staffMapper.alterDepartment(department, staff);
    }

    /**
     * 获取所有员工列表。
     *
     * @return 包含所有员工信息的列表。
     */
    public List<MutableStaff> getStaffList() {
        return staffMapper.queryAll();
    }

    /**
     * 通过id查找特定的员工信息。
     *
     * @param id 员工的ID。
     * @return 员工信息类。
     */
    public MutableStaff getStaffById(long id) {
        return staffMapper.queryById(id);
    }

    /**
     * 获取所有部门信息。
     *
     * @return 包含所有部门信息的列表。
     */
    @NotNull
    public List<MutableDepartment> getDepartmentList() {
        return departmentMapper.queryAll();
    }

    /**
     * 通过id查找特定的部门信息。
     *
     * @param id 部门的ID。
     * @return 部门信息类。
     */
    public MutableDepartment getDepartmentById(long id) {
        return departmentMapper.queryById(id);
    }

    /**
     * 获取部门信息的层级关系。
     *
     * @return 一个列表，列表中是所有最上级部门。
     */
    public ArrayList<DepartmentTreeNode> getDepartmentTree() throws DepartmentTreeException {
        return DepartmentTreeNode.getTree(getDepartmentList());
    }

    /**
     * 删除一个部门。删除后，该部门下的员工的部门将暂时变为空。<br/>
     * 同时，这个部门的子部门都会被删除。
     *
     * @param department 要删除的部门的id。
     */
    public void deleteDepartments(long department) {
        departmentMapper.deleteById(department);
    }

    /**
     * 添加一个部门。
     *
     * @param department 要添加的部门。
     * @return 是否成功添加。
     */
    public boolean addDepartment(@NotNull MutableDepartment department) {
        try {
            if ((department.getLevel() == MutableDepartment.TOP_LEVEL) == (department.getParentDepartment() == null)) {
                if (department.getLevel() == MutableDepartment.TOP_LEVEL) {
                    departmentMapper.addDepartment(department.generateMap());
                    return true;
                } else {
                    MutableDepartment parent = departmentMapper.queryById(department.getParentDepartment());
                    if (parent == null) {
                        return false;
                    } else if (parent.getLevel() + 1 == department.getLevel()) {
                        departmentMapper.addDepartment(department.generateMap());
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }

    /**
     * 更新一个特定的部门的名称。
     *
     * @param department 要修改的部门的id。
     * @param newName    新的名称。
     */
    public void updateSingleDepartment(long department, @NotNull String newName) {
        departmentMapper.alterName(newName, department);
    }

    /**
     * 查询一个员工的所有薪水信息。
     *
     * @param staff 要查询的员工的id。
     * @return 薪水信息。这里返回的是不可变列表。
     */
    public List<MutableSalary> getSalaryListByStaff(long staff) {
        return salaryMapper.queryById(staff);
    }

    /**
     * 根据月份查询一个员工特定月的薪水信息。
     *
     * @param staff 要查询的员工的id。
     * @param month 要查询的月份。月份定义同{@link Salary#getMonth()}。
     * @return 查询到的薪水信息。如果给定的信息没有查询到薪水信息则返回null。
     */
    @Nullable
    public MutableSalary getMutableSalary(long staff, int month) {
        return salaryMapper.queryByMonth(staff, month);
    }

    /**
     * 为一名员工设置薪水信息。
     *
     * @param staff  要设置薪水信息的员工的id。
     * @param salary 要设置的薪水信息。
     * @return 是否添加成功。执行过程中如果抛出数据库异常则返回false。如果数据不合法则不会添加，并返回false。
     * @see Salary#isLegal()
     */
    public boolean setSalary(long staff, @NotNull Salary salary) {
        try {
            if (salary.isLegal()) {
                salaryMapper.addSalary(salary.generateMap(staff));
                return true;
            } else {
                return false;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            return false;
        }
    }

    /**
     * 为一名员工更改一个薪水信息。
     *
     * @param staff  要更改薪水信息的员工的id。
     * @param salary 要更改的薪水信息。
     * @return 是否修改成功。执行过程中如果抛出数据库异常则返回false。
     */
    public boolean updateSalary(long staff, @NotNull Salary salary) {
        try {
            salaryMapper.alterSalary(salary.generateMap(staff));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
