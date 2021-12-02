package cn.edu.nwpu.salarymanagementsystem.controller;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import cn.edu.nwpu.salarymanagementsystem.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @ClassName StaffController {@link StaffService}
 * @Description 员工控制器
 * @Author xuLyi
 * @Version 1.0
 */
@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;


    /**
     * 员工注销
     *
     * @return Login
     */
    @RequestMapping(value = "/logout", method = GET)
    public String logout(HttpSession session) {
        session.removeAttribute("staff");
        session.invalidate();
        return "../Login";
    }

    /**
     * 获取用户信息
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/ShowInfo")
    public String getPersonalInformation(Model model, HttpSession session) {
        Long Id = (Long) session.getAttribute("staff");
        model.addAttribute("staffInfo",staffService.getPersonalInformation(Id));
        //model.addAttribute(staffService.getPersonalInformation(Id));
        return "/Staff/ShowInfo";
    }

    /**
     * 进入员工信息修改页面
     *
     * @return
     */
    @RequestMapping(value = "/editStaff", method = GET)
    public String showStaffForm(){
        return "/Staff/StaffEdit";
    }
    /**
     * 更新用户个人信息
     *
     * @param staff
     * @return
     */
    @RequestMapping(value = "/editStaff", method = POST)
    public String updatePersonalInformation(Staff staff) {
        staffService.updatePersonalInformation(staff);
        return "redirect:/Staff/ShowInfo";
    }

    /**
     * 更新密码
     *
     * @param password1
     * @param password2
     * @param session
     */
    @RequestMapping("/changePassword")
    public String updatePassword(String password1, String password2, HttpSession session) {
        if (password1.equals(password2)) {
            Staff staff = (Staff) session.getAttribute("staff");
            staffService.updatePassword(staff.getId(), password1);
        } else
            return "error";
        return "redirect:/Staff/ShowInfo";
    }

    /**
     * 查询所有工资信息。
     *
     * @return 工资信息。
     */
    @RequestMapping("/showSalary")
    public String getSalaryList(Model model, HttpSession session) {
        long id = (long) session.getAttribute("staff");
        model.addAttribute("staffName",staffService.getPersonalInformation(id).getName());
        model.addAttribute("salaryList",staffService.getSalaryList(id));
        return "/Staff/ShowSalary";
    }

    /**
     * 计算所得税
     *
     * @return
     */
    @RequestMapping("/tax")
    public String tax(){
        //TODO
        return null;
    }

}
