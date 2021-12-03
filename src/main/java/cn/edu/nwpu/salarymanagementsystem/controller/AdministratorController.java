package cn.edu.nwpu.salarymanagementsystem.controller;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.MutableDepartment;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.MutableSalary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.Salary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff;
import cn.edu.nwpu.salarymanagementsystem.pojo.exception.DepartmentTreeException;
import cn.edu.nwpu.salarymanagementsystem.pojo.exception.DuplicatedUserException;
import cn.edu.nwpu.salarymanagementsystem.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @ClassName AdministratorController
 * @Description 管理员控制器
 * @Author xuLyi
 * @Version 1.0
 */
@Controller
@RequestMapping("/Admin")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    /**
     * 管理员注销
     *
     * @param session session
     * @return Login页面
     */
    @RequestMapping(value = "/logout", method = GET)
    public String logout(HttpSession session) {
        session.removeAttribute("administrator");
        session.invalidate();
        return "redirect:../Login";
    }

    /**
     * 管理员首页，显示所有用户
     *
     * @return ShowStaff页面
     */
    @RequestMapping(value = "/showStaff", method = GET)
    public String showAllStaff(Model model) {
        model.addAttribute("staffList",administratorService.getStaffList());
        return "/Admin/ShowStaff";
    }

    /**
     * 进入添加员工页面
     *
     * @return addStaff页面
     */
    @RequestMapping(value = "/addStaff", method = GET)
    public String showStaffForm() {
        return "/Admin/AddStaff";
    }

    /**
     * 添加员工
     *
     * @param staff    新的员工信息
     * @param password 初始密码
     * @return 返回管理员主页
     */
    @RequestMapping(value = "/addStaff", method = POST)
    public String addStaff(MutableStaff staff, String password) {
        try {
            administratorService.addStaff(staff, password);
        } catch (DuplicatedUserException e) {
            e.printStackTrace();
        }
        return "redirect:/Admin/ShowStaff";
    }

    /**
     * 更改一个员工的部门。
     */
    @RequestMapping("/changeStaffDepartment")
    public String changeDepartment(long staff, long department) throws SQLIntegrityConstraintViolationException {
        administratorService.updateStaffDepartment(staff,department);
        return "redirect:/Admin/ShowStaff";
    }

    /**
     * 删除员工
     *
     * @param id 要删除的员工ID
     * @return showstaff 返回管理员主页
     */
    @RequestMapping("/deleteStaff")
    public String removeStaff(long id) {
        administratorService.deleteStaff(id);
        return "redirect:/Admin/ShowStaff";
    }

    /**
     * 获取所有部门信息
     *
     * @param model model
     * @return ShowDepartment页面
     */
    @RequestMapping("/showDepartment")
    public String getDepartmentList(Model model) {
        model.addAttribute("departmentList",administratorService.getDepartmentList());
        return "/Admin/ShowDepartment";
    }

    /**
     * 获取部门信息的层级关系。
     *
     * @return 一个列表，列表中是所有最上级部门。
     */
    @RequestMapping
    public String getDepartmentTree(Model model) {
        try {
            model.addAttribute("departmentTree",administratorService.getDepartmentTree());
        } catch (DepartmentTreeException e) {
            e.printStackTrace();
        }
        return "/Admin/ShowDepartment";
    }

    /**
     * 删除部门
     *
     * @param department 要删除的部门
     * @return ShowDepartment页面
     */
    @RequestMapping("/deleteDepartment")
    public String deleteDepartments(long department) {
        administratorService.deleteDepartments(department);
        return "redirect:/Admin/ShowDepartment";
    }

    /**
     * 进入添加部门页面
     *
     * @return AddDepartment
     */
    @RequestMapping(value = "/addDepartment", method = GET)
    public String showDepartmentForm() {
        return "/Admin/AddDepartment";
    }

    /**
     * 添加一个部门
     *
     * @param department 要添加的部门
     * @return ShowDepartment 页面
     */
    @RequestMapping(value = "/addDepartment", method = POST)
    public String addDepartment(MutableDepartment department) {
        administratorService.addDepartment(department);
        return "redirect:/Admin/ShowDepartment";
    }

    /**
     * 进入修改部门页面
     *
     * @return EditDepartment页面
     */
    @RequestMapping(value = "/editDepartment", method = GET)
    public String showEditDepartmentForm() {
        return "/Admin/EditDepartment";
    }

    /**
     * 提交更新部门名称
     *
     * @param department 更新D部门
     * @return ShowDepartment
     */
    @RequestMapping(value = "/editDepartment", method = POST)
    public String updateDepartment(MutableDepartment department) {
        administratorService.addDepartment(department);
        return "redirect:/Admin/ShowDepartment";
    }

    /**
     * 查询一个员工的所有薪水信息。
     *
     * @param id 要查询的员工信息。
     * @return 薪水信息。这里返回的是不可变列表。
     */
    @RequestMapping("/searchSalary")
    public List<MutableSalary> getSalaryListByStaff(long id) {
        return administratorService.getSalaryListByStaff(id);
    }

    /**
     * 进入设置薪水页面
     *
     * @return EditSalary
     */
    @RequestMapping(value = "/addSalary", method = GET)
    public String showSetSalaryForm() {
        return "/Admin/EditSalary";
    }

    /**
     * 为一名员工设置一个薪水信息。
     *
     * @param staff 目标员工
     * @param salary 设置的薪水
     * @return ShowStaff
     */
    @RequestMapping(value = "/addSalary", method = POST)
    public String setSalary(long staff, Salary salary) {
        administratorService.setSalary(staff, salary);
        return "redirect:/Admin/ShowStaff";
    }

    /**
     * 进入更改薪水页面
     *
     * @return EditSalary页面
     */
    @RequestMapping(value = "/editSalary", method = GET)
    public String showEditSalaryForm() {
        return "/Admin/EditSalary";
    }

    /**
     * 为一名员工更改一个薪水信息。
     *
     * @param staff 目标员工
     * @param salary 薪水信息
     * @return ShowStaff
     */
    @RequestMapping(value = "/editSalary", method = POST)
    public String updateSalary(long staff, Salary salary) {
        administratorService.updateSalary(staff, salary);
        return "redirect:/Admin/ShowStaff";
    }
}
