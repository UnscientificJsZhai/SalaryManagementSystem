package cn.edu.nwpu.salarymanagementsystem.controller;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.Department;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.DepartmentTreeNode;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.department.MutableDepartment;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.MutableSalary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.salary.Salary;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff;
import cn.edu.nwpu.salarymanagementsystem.pojo.exception.DepartmentTreeException;
import cn.edu.nwpu.salarymanagementsystem.pojo.exception.DuplicatedUserException;
import cn.edu.nwpu.salarymanagementsystem.service.AdministratorService;
import cn.edu.nwpu.salarymanagementsystem.service.StaffService;
import kotlin.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
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

    private AdministratorService administratorService;
    private StaffService staffService;

    @Autowired
    public void setAdministratorService(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @Autowired
    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }

    @RequestMapping("/AdminView")
    public String adminHome() {
        return "allStaff-info";
    }

    /**
     * 管理员点击用户详情，进入编辑用户信息页面，可以更改员工的部门信息。之后点击保存按钮，调用此方法保存数据。
     *
     * @param id         员工id。
     * @param department 修改后的部门id。
     * @return 跳转到的URL。
     */
    @RequestMapping(value = "/editStaff", method = POST)
    public String updatePersonalInformation(@RequestParam(value = "id", defaultValue = "") long id,
                                            @RequestParam(value = "department", defaultValue = "") Long department,
                                            Model model) {
        try {
            administratorService.updateStaffDepartment(id, department);
        } catch (Exception e) {
            String result = "无效的部门id";
            model.addAttribute("result",result);
            return "/wa";
        }
        //noinspection SpringMVCViewInspection
        return "redirect:/Admin/ShowInfo" + "?id=" + id;
    }

    /**
     * 获取用户信息。
     *
     * @param model model。
     * @return 跳转到的URL：ShowInfo页面。
     */
    @RequestMapping("/ShowInfo")
    public String getPersonalInformation(Model model, long id) {
        model.addAttribute("staffInfo", staffService.getPersonalInformation(id));
        model.addAttribute("salaryList", staffService.getSalaryList(id));
        return "personal-info";
    }

    /**
     * 显示所有用户。
     *
     * @return ShowStaff页面。
     */
    @RequestMapping(value = "/showStaff", method = GET)
    public String showAllStaff(Model model) {
        ArrayList<Pair<MutableStaff, String>> staffPairList = new ArrayList<>();
        List<MutableStaff> staffList = administratorService.getStaffList();
        for (MutableStaff staff : staffList) {
            Long departmentId = staff.getDepartment();
            if (departmentId == null) {
                staffPairList.add(new Pair<>(staff, "未分配部门"));
            } else {
                Department department = administratorService.getDepartmentById(departmentId);
                staffPairList.add(new Pair<>(staff, department.getName()));
            }

        }
        model.addAttribute("staffList", staffPairList);
        return "allStaff-info";
    }

    /**
     * 进入添加员工页面。
     *
     * @return addStaff页面。
     */
    @RequestMapping(value = "/addStaff", method = GET)
    public String showStaffForm() {
        return "/add-staff";
    }

    /**
     * 添加员工。
     *
     * @param id       新的员工信息。
     * @param password 初始密码。
     * @return 返回管理员主页。
     */
    @RequestMapping(value = "/addStaff", method = POST)
    public String addStaff(@RequestParam(value = "id", defaultValue = "") long id,
                           @RequestParam(value = "name", defaultValue = "") String name,
                           @RequestParam(value = "phoneNumber", defaultValue = "") String phoneNumber,
                           @RequestParam(value = "email", defaultValue = "") String email,
                           @RequestParam(value = "department", defaultValue = "") Long department,
                           @RequestParam(value = "password", defaultValue = "") String password,
                           Model model) {
        try {
            if (administratorService.getStaffById(id) == null) {
                MutableStaff staff = new MutableStaff(id, name, phoneNumber, email, department);
                administratorService.addStaff(staff, password);
            }
        } catch (DuplicatedUserException e) {
            model.addAttribute("result", "添加员工错误！");
            return "/wa";
        }
        return "redirect:/Admin/showStaff";
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
        return "redirect:/Admin/showStaff";
    }

    /**
     * 获取所有部门信息。
     *
     * @param model model。
     * @return ShowDepartment页面。
     */
    @RequestMapping("/showDepartment")
    public String getDepartmentList(Model model) {
        List<MutableDepartment> list = administratorService.getDepartmentList();

        List<DepartmentTreeNode> treeNodes;
        try {
            treeNodes = DepartmentTreeNode.getTree(list);
        } catch (DepartmentTreeException e) {
            e.printStackTrace();
            treeNodes = new ArrayList<>(0);
        }
        model.addAttribute("treeNodes", treeNodes);
        return "/allDepartment-info";
    }

    /**
     * 获取部门信息的层级关系。
     *
     * @return 一个列表，列表中是所有最上级部门。
     */
    @RequestMapping
    public String getDepartmentTree(Model model) {
        try {
            model.addAttribute("departmentTree", administratorService.getDepartmentTree());
        } catch (DepartmentTreeException e) {
            e.printStackTrace();
        }
        return "/Admin/ShowDepartment";
        //TODO 暂时未实现
    }

    /**
     * 通过id查找部门。
     *
     * @param id 待查找的部门id。
     * @return ShowStaff页面。
     */
    @RequestMapping("/searchDepartment")
    public String searchDepartment(long id, Model model) {
        model.addAttribute("departmentResult", administratorService.getStaffById(id));
        return "/Admin/showStaff";
        //TODO 暂时未实现
    }

    /**
     * 删除部门。
     *
     * @param id 要删除的部门。
     * @return ShowDepartment页面。
     */
    @RequestMapping("/deleteDepartment/{id}")
    public String deleteDepartments(@PathVariable long id) {
        administratorService.deleteDepartments(id);
        return "redirect:/Admin/showDepartment";
    }

    /**
     * 进入添加部门页面。
     *
     * @return AddDepartment。
     */
    @RequestMapping(value = "/addDepartment", method = GET)
    public String showDepartmentForm() {
        return "/add-department";
    }

    /**
     * 添加一个部门。
     *
     * @param department 要添加的部门。
     * @return ShowDepartment 页面。
     */
    @RequestMapping(value = "/addDepartment", method = POST)
    public String addDepartment(MutableDepartment department) {
        administratorService.addDepartment(department);
        return "redirect:/Admin/showDepartment";
    }

    /**
     * 进入修改部门页面。
     *
     * @return EditDepartment页面。
     */
    @RequestMapping(value = "/editDepartment/{departmentId}", method = GET)
    public String showEditDepartmentForm(Model model, @PathVariable long departmentId) {
        model.addAttribute("departmentInfo", administratorService.getDepartmentById(departmentId));
        return "/alter-department";
    }

    /**
     * 提交更新部门名称。
     *
     * @param department 更新的部门。
     * @return ShowDepartment。
     */
    @RequestMapping(value = "/editDepartment", method = POST)
    public String updateDepartment(MutableDepartment department) {
        administratorService.updateSingleDepartment(department.getId(),department.getName());
        return "redirect:/Admin/showDepartment";
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
     * 进入设置薪水页面。
     *
     * @return 设置薪水的页面。
     */
    @RequestMapping(value = "/addSalary/{id}", method = GET)
    public String showSetSalaryForm(Model model, @PathVariable long id) {
        model.addAttribute("staffInfo", administratorService.getStaffById(id));
        return "/add-salary";
    }

    /**
     * 为一名员工设置一个薪水信息。
     *
     * @param month 设置的薪水。
     * @return 设置薪水的页面（也是展示薪水信息的页面）。
     */
    @RequestMapping(value = "/addSalary", method = POST)
    public String setSalary(@RequestParam(value = "month", defaultValue = "") int month,
                            @RequestParam(value = "postWage", defaultValue = "") double postWage,
                            @RequestParam(value = "meritPay", defaultValue = "") double meritPay,
                            @RequestParam(value = "seniorityPay", defaultValue = "") double seniorityPay,
                            @RequestParam(value = "subsidy", defaultValue = "") double subsidy,
                            @RequestParam(value = "paid", defaultValue = "") boolean paid,
                            long id,
                            HttpSession session, Model model) {
        MutableSalary salary = new MutableSalary(month, postWage, meritPay, seniorityPay, subsidy, paid);
        if (administratorService.setSalary(id, salary)) {
            return "redirect:/Admin/showStaff";
        } else {
            session.removeAttribute("administrator");
            String result = "无效的薪水设置";
            model.addAttribute("result", result);
            return "wa";//TODO 准备添加404页面
        }
    }

    /**
     * 进入更改薪水页面。
     *
     * @return 更改薪水页面。
     */
    @RequestMapping(value = "/editSalary/{id}/{month}", method = GET)
    public String showEditSalaryForm(Model model,
                                     @PathVariable long id,
                                     @PathVariable int month) {
        Salary salary = administratorService.getMutableSalary(id, month);
        model.addAttribute("id", id);
        model.addAttribute("salary", salary);
        return "alter-salary";
    }

    /**
     * 为一名员工更改一个薪水信息。
     *
     * @return 更改后返回到员工信息页面。
     */
    @RequestMapping(value = "/editSalary", method = POST)
    public String updateSalary(long id,
                               @RequestParam(value = "month", defaultValue = "") int month,
                               @RequestParam(value = "postWage", defaultValue = "") double postWage,
                               @RequestParam(value = "meritPay", defaultValue = "") double meritPay,
                               @RequestParam(value = "seniorityPay", defaultValue = "") double seniorityPay,
                               @RequestParam(value = "subsidy", defaultValue = "") double subsidy,
                               @RequestParam(value = "paid", defaultValue = "") boolean paid) {
        MutableSalary salary = new MutableSalary(month, postWage, meritPay, seniorityPay, subsidy, paid);
        administratorService.updateSalary(id, salary);
        return "redirect:/Admin/showStaff";
    }
}
