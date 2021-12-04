package cn.edu.nwpu.salarymanagementsystem.controller;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import cn.edu.nwpu.salarymanagementsystem.service.StaffService;
import cn.edu.nwpu.salarymanagementsystem.utils.StringUtil;
import cn.edu.nwpu.salarymanagementsystem.utils.TaxUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 员工操作的控制器。
 *
 * @Author xuLyi
 * @see StaffService
 */
@Controller
@RequestMapping("/Staff")
public class StaffController {

    private StaffService staffService;

    @Autowired
    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }

    /**
     * 获取用户信息。
     *
     * @param model model。
     * @return 信息展示页面。
     */
    @RequestMapping("/ShowInfo")
    public String getPersonalInformation(Model model,HttpSession session) {
        Staff staff = (Staff)session.getAttribute("staff");
        long id = staff.getId();
        model.addAttribute("staffInfo", staffService.getPersonalInformation(id));
        model.addAttribute("salaryList", staffService.getSalaryList(id));
        model.addAttribute("taxInfo", TaxUtil.totalTax(staffService.getSalaryList(id)));
        return "personal-info";
    }

    /**
     * 更新用户个人信息。
     *
     * @param id          要更新个人信息的用户id。
     * @param name        用户姓名。
     * @param phoneNumber 手机号。
     * @param email       电子邮箱。
     * @param department  部门信息。
     * @param session     session。
     * @return 返回到当前用户。
     */
    @RequestMapping(value = "/editStaff", method = POST)
    public String updatePersonalInformation(@RequestParam(value = "id", defaultValue = "") long id,
                                            @RequestParam(value = "name", defaultValue = "") String name,
                                            @RequestParam(value = "phoneNumber", defaultValue = "") String phoneNumber,
                                            @RequestParam(value = "email", defaultValue = "") String email,
                                            @RequestParam(value = "department", defaultValue = "") Long department,
                                            HttpSession session,
                                            Model model) {
        if (name == null) {
            name = "";
        }
        if (phoneNumber == null) {
            phoneNumber = "";
        }
        if (email == null) {
            email = "";
        }
        if (StringUtil.isEmail(email) && StringUtil.isPhone(phoneNumber)) {
            Staff staff = new MutableStaff(id, name, phoneNumber, email, department);
            session.setAttribute("staff", staff);
            staffService.updatePersonalInformation(staff);
            //noinspection SpringMVCViewInspection
            return "redirect:/Staff/ShowInfo";
        } else {
            String result = "错误的更改";
            model.addAttribute("result",result);
            return "/wa";
        }
    }

    /**
     * 更新密码。
     *
     * @param password1 第一次输入的密码。
     * @param password2 第二次输入的密码。
     * @param session   session。
     */
    @RequestMapping("/changePassword")
    public String updatePassword(String password1, String password2, HttpSession session, Model model) {
        if (password1.equals(password2)) {
            Staff staff = (Staff) session.getAttribute("staff");
            staffService.updatePassword(staff.getId(), password1);
            //noinspection SpringMVCViewInspection
            return "redirect:/Staff/ShowInfo";
        } else {
            String error = "Change Failed";
            model.addAttribute("ERROR", error);
            return "redirect:/Staff/editStaff";
        }
    }
}
