package cn.edu.nwpu.salarymanagementsystem.service;

import cn.edu.nwpu.salarymanagementsystem.dao.AdministratorMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.DepartmentMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.SalaryMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.StaffMapper;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.Department;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.DepartmentTreeNode;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.MutableDepartment;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.MutableSalary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.Salary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import cn.edu.nwpu.salarymanagementsystem.pojo.exception.DepartmentTreeException;
import cn.edu.nwpu.salarymanagementsystem.pojo.exception.DuplicatedUserException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
     * @param administratorId 用户名。
     * @param password 密码。
     * @return 是否登录成功。如果是，则返回true。
     */
    public boolean login(@NotNull String username, @NotNull String password) {
        //TODO 等待DAO
        return false;
        /*return administratorMapper.login(username, password) != null;*/
    }

    /**
     * 添加员工。
     *
     * @param staff    新的员工信息。
     * @param password 初始密码。
     * @throws DuplicatedUserException 如果新员工用户名和已经存在的员工用户名重复则抛出此异常。
     */
    public void addStaff(@NotNull MutableStaff staff, @NotNull String password) throws DuplicatedUserException {
        //TODO 等待   DAO
/*        try {
            staffMapper.addStaff(staff, password);
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new DuplicatedUserException(staff.getId(), e);
        }*/
    }

    /**
     * 删除员工。
     *
     * @param staff 要删除的员工。
     */
    public void removeStaff(@NotNull Staff staff) {
//        staffMapper.deleteStaff(staff.getId());
        //TODO 等待Dao更改
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
     * 获取所有部门信息。
     *
     * @return 包含所有部门信息的列表。
     */
    public List<MutableDepartment> getDepartmentList() {
        return departmentMapper.queryAll();
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
     * @param department 要删除的部门。
     */
    public void deleteDepartments(@NotNull Department department) {
        //TODO 等待DAO
        /*departmentMapper.deleteByName(department.getName());*/
    }

    /**
     * 添加一个部门。
     *
     * @param department 要添加的部门。
     * @return 是否成功添加。如果部门名称设置为{@link DepartmentMapper#ROOT_DEPARTMENT}则会添加失败。
     */
    public boolean addDepartment(@NotNull MutableDepartment department) {
        //TODO 等待DAO
        return false;
       /* if (!Objects.equals(department.getName(), DepartmentMapper.ROOT_DEPARTMENT)) {
            try {
                if (department.getLevel() == 1) {
                    departmentMapper.addDepartment(department);
                } else {
//                    departmentMapper.addDepartment(department, department.getParentDepartment());
                    //TODO 等待Dao更改
                }
                return true;
            } catch (SQLException e) {
                return false;
            }

        } else {
            return false;
        }*/
    }

    /**
     * 更新一个特定的部门的名称。
     *
     * @param department 要修改的部门。
     * @param newName    新的名称。
     */
    public void updateSingleDepartment(@NotNull MutableDepartment department, @NotNull String newName) {
        //TODO 等待DAO
        /*departmentMapper.alterName(newName, department.getName());*/
    }

    /**
     * 查询一个员工的所有薪水信息。
     *
     * @param staff 要查询的员工信息。
     * @return 薪水信息。这里返回的是不可变列表。
     */
    public List<MutableSalary> getSalaryListByStaff(@NotNull Staff staff) {
//        return salaryMapper.queryAll(staff.getId());
        //TODO 等待Dao更改
        return null;
    }

    /**
     * 为一名员工设置薪水信息。
     *
     * @param staff  要设置薪水信息的员工。
     * @param salary 要设置的薪水信息。
     */
    public void setSalary(@NotNull Staff staff, @NotNull Salary salary) {
//        salaryMapper.addSalary(salary, staff.getId());
        //TODO 等待Dao更改
    }

    /**
     * 为一名员工更改一个薪水信息。
     *
     * @param staff  要更改薪水信息的员工。
     * @param salary 要更改的薪水信息。
     */
    public void updateSalary(@NotNull Staff staff, @NotNull Salary salary) {
//        salaryMapper.alterSalary(salary, staff.getId());
        //TODO 等待Dao更改
    }
}
