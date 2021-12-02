package cn.edu.nwpu.salarymanagementsystem.controller;

import cn.edu.nwpu.salarymanagementsystem.dao.StaffMapper;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.Department;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.MutableDepartment;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.MutableSalary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.Salary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import cn.edu.nwpu.salarymanagementsystem.pojo.exception.DuplicatedUserException;
import cn.edu.nwpu.salarymanagementsystem.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

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
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    /**
     * 管理员注销
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = GET)
    public String logout(HttpSession session) {
        session.removeAttribute("administrator");
        session.invalidate();
        return "redirect:/Login";
    }

    /**
     * 管理员首页，显示所有用户
     *
     * @return
     */
    @RequestMapping(value = "/showStaff", method = GET)
    public String showAllStaff(Model model) {
        model.addAllAttributes(administratorService.getStaffList());
        return "showStaff";
    }

    /**
     * 进入添加员工页面
     *
     * @return addStaff.jsp
     */
    @RequestMapping(value = "/addstaff", method = GET)
    public String showStaffForm() {
        return "addStaff";
    }

    /**
     * 添加员工
     *
     * @param staff    新的员工信息
     * @param password 初始密码
     * @return 返回管理员主页
     */
    @RequestMapping(value = "/addstaff", method = POST)
    public String addStaff(MutableStaff staff, String password) {
        try {
            administratorService.addStaff(staff, password);
        } catch (DuplicatedUserException e) {
            e.printStackTrace();
        }
        return "redirect:/showstaff";
    }

    public String changeDepartment(){
        //TODO
        return null;
    }

    /**
     * 删除员工
     *
     * @param id
     * @return showstaff 返回管理员主页
     */
    @RequestMapping("/staffDel")
    public String removeStaff(long id) {
        administratorService.deleteStaff(id);
        return "redirect:/showstaff";
    }

    /**
     * 获取所有部门信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/showdepartment")
    public String getDepartmentList(Model model) {
        model.addAllAttributes(administratorService.getDepartmentList());
        return "redirect:/showdepartment";
    }

    /**
     * 获取部门信息的层级关系。
     *
     * @return 一个列表，列表中是所有最上级部门。
     */
    public String getDepartmentTree() {
        //TODO
        return null;
    }

    /**
     * 删除部门
     *
     * @param department 要删除的部门
     * @return
     */
    @RequestMapping("/deleteDepartment")
    public String deleteDepartments(long department) {
        administratorService.deleteDepartments(department);
        return "redirect:/showdepartment";
    }

    /**
     * 进入添加部门页面
     *
     * @return
     */
    @RequestMapping(value = "/addDepartment", method = GET)
    public String showDepartmentForm() {
        return "addDepartment";
    }

    /**
     * 添加一个部门
     *
     * @param department 要添加的部门
     * @return
     */
    @RequestMapping(value = "/addDepartment", method = POST)
    public String addDepartment(MutableDepartment department) {
        administratorService.addDepartment(department);
        return "redirect:/showdepartment";
    }

    /**
     * 进入修改部门页面
     *
     * @return
     */
    @RequestMapping(value = "/editDepartment", method = GET)
    public String showEditDepartmentForm() {
        return "editDepartment";
    }

    /**
     * 提交更新部门名称
     *
     * @param department
     * @return
     */
    @RequestMapping(value = "/editDepartment", method = POST)
    public String updateDepartment(MutableDepartment department) {
        administratorService.addDepartment(department);
        return "redirect:/showdepartment";
    }

    /**
     * 查询一个员工的所有薪水信息。
     *
     * @param id 要查询的员工信息。
     * @return 薪水信息。这里返回的是不可变列表。
     */
    @RequestMapping("/getSalaryListByStaff")
    public List<MutableSalary> getSalaryListByStaff(long id) {
        return administratorService.getSalaryListByStaff(id);
    }

    /**
     * 进入设置薪水页面
     *
     * @return
     */
    @RequestMapping(value = "/setSalary", method = GET)
    public String showSetSalaryForm() {
        return "editSalary";
    }

    /**
     * 为一名员工设置一个薪水信息。
     *
     * @param staff
     * @param salary
     * @return
     */
    @RequestMapping(value = "/setSalary", method = POST)
    public String setSalary(long staff, Salary salary) {
        administratorService.setSalary(staff, salary);
        return "redirect:/showStaff";
    }

    /**
     * 进入更改薪水页面
     *
     * @return
     */
    @RequestMapping(value = "/editSalary", method = GET)
    public String showEditSalaryForm() {
        return "editSalary";
    }

    /**
     * 为一名员工更改一个薪水信息。
     *
     * @param staff
     * @param salary
     * @return
     */
    @RequestMapping(value = "/editSalary", method = POST)
    public String updateSalary(long staff, Salary salary) {
        administratorService.updateSalary(staff, salary);
        return "redirect:/showStaff";
    }
}
