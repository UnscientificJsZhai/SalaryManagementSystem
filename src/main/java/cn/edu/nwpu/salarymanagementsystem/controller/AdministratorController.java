package cn.edu.nwpu.salarymanagementsystem.controller;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.MutableDepartment;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.MutableSalary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.Salary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import cn.edu.nwpu.salarymanagementsystem.pojo.exception.DepartmentTreeException;
import cn.edu.nwpu.salarymanagementsystem.pojo.exception.DuplicatedUserException;
import cn.edu.nwpu.salarymanagementsystem.service.AdministratorService;
import kotlin.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



    @RequestMapping("/AdminView")
    public String adminHome(){

        return "/test1/staff-info";
    }

    /**
     * 显示所有用户
     *
     * @return ShowStaff页面
     */
    @RequestMapping(value = "/showStaff", method = GET)
    public String showAllStaff(Model model) {
        ArrayList<Pair<MutableStaff,String>> staffPairList = new ArrayList<>();
        List<MutableStaff> staffList = administratorService.getStaffList();
        for(MutableStaff staff:staffList){
            staffPairList.add(new Pair<>(staff,administratorService.getDepartmentById(staff.getDepartment()).getName()));
        }
        model.addAttribute("staffList",staffPairList);
        return "/test1/staff-info";
    }

    /**
     * 通过ID查找员工
     *
     * @param id 待查找的员工id
     * @return ShowStaff页面
     */
    @RequestMapping("/searchStaff")
    public String searchStaff(long id, Model model) {
        model.addAttribute("staffResult", administratorService.getStaffById(id));
        return "/Admin/ShowStaff";
    }

    @RequestMapping("/showStaffResult")
    public String showStaffResult(Model model) {
        model.getAttribute("staffResult");
        return "/Admin/ShowStaff";
    }

    /**
     * 进入添加员工页面
     *
     * @return addStaff页面
     */
    @RequestMapping(value = "/addStaff", method = GET)
    public String showStaffForm() {
        return "/test1/add-staff";
    }

    /**
     * 添加员工
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
     * 进入修改员工部门界面
     * @param model model
     * @param staff 需要修改部门的员工
     * @return editStaff
     */
    @RequestMapping(value = "/changeStaffDepartment", method = GET)
    public String showStaffDepartmentForm(Model model,Long staff){
        model.addAttribute("staffInfo",administratorService.getStaffById(staff));
        model.addAttribute("departmentList",administratorService.getDepartmentList());
        return "/Admin/EditStaff";
    }

    /**
     * 更改一个员工的部门。
     */
    @RequestMapping(value = "/changeStaffDepartment", method = POST)
    public String changeDepartment(Long staff, Long department) throws SQLIntegrityConstraintViolationException {
        administratorService.updateStaffDepartment(staff,department);
        return "redirect:/Admin/ShowStaff";
    }

    /**
     * 删除员工
     *
     * @param id 要删除的员工id
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
     * 通过id查找部门
     *
     * @param id 待查找的部门id
     * @return ShowStaff页面
     */
    @RequestMapping("/searchDepartment")
    public String searchDepartment(long id, Model model) {
        model.addAttribute("departmentResult",administratorService.getStaffById(id));
        return "/Admin/ShowStaff";
    }

    /**
     * 删除部门
     *
     * @param department 要删除的部门
     * @return ShowDepartment页面
     */
    @RequestMapping("/deleteDepartment")
    public String deleteDepartments(Long department) {
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
    public String showEditDepartmentForm(Model model, Long department) {
        model.addAttribute("departmentInfo", administratorService.getDepartmentById(department));
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
    public String showSetSalaryForm(Model model,long id) {
        model.addAttribute("staffInfo",administratorService.getStaffById(id));
        return "/test1/add-salary";
    }

    /**
     * 为一名员工设置一个薪水信息。
     *
     * @param salary 设置的薪水
     * @return ShowStaff
     */
    @RequestMapping(value = "/addSalary", method = POST)
    public String setSalary(Salary salary,long id) {
        administratorService.setSalary(id, salary);
        return "redirect:/Admin/ShowStaff";
    }

    /**
     * 进入更改薪水页面
     *
     * @return EditSalary页面
     */
    @RequestMapping(value = "/editSalary", method = GET)
    public String showEditSalaryForm(Model model, Long staff) {
        model.addAttribute("salaryList", administratorService.getSalaryListByStaff(staff));
        model.addAttribute("staffInfo", administratorService.getStaffById(staff));
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
    public String updateSalary(Long staff, Salary salary) {
        administratorService.updateSalary(staff, salary);
        return "redirect:/Admin/ShowStaff";
    }
}
