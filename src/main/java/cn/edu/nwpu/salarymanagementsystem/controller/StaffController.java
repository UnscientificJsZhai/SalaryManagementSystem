package cn.edu.nwpu.salarymanagementsystem.controller;

import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import cn.edu.nwpu.salarymanagementsystem.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
@RequestMapping("/Staff")
public class StaffController {

    @Autowired
    private StaffService staffService;




    /**
     * 获取用户信息
     *
     * @param model model
     * @return ShowInfo页面
     */
    @RequestMapping("/ShowInfo")
    public String getPersonalInformation(Model model, long id) {
        model.addAttribute("staffInfo",staffService.getPersonalInformation(id));
        model.addAttribute("salaryList",staffService.getSalaryList(id));
        return "personal-info";
    }


    @RequestMapping(value = "/editStaff", method = POST)
    public String updatePersonalInformation(@RequestParam(value = "id", defaultValue = "")long id,
                                            @RequestParam(value = "name", defaultValue = "")String name,
                                            @RequestParam(value = "phoneNumber", defaultValue = "")String phoneNumber,
                                            @RequestParam(value = "email", defaultValue = "")String email,
                                            @RequestParam(value = "department", defaultValue = "")Long department,
                                            HttpSession session) {
        if (name == null) {
            name = "";
        }
        if(phoneNumber == null) {
            phoneNumber = "";
        }
        if(email == null) {
            email = "";
        }
        Staff staff = new MutableStaff(id, name, phoneNumber, email, department);
        session.setAttribute("staff",staff);
        staffService.updatePersonalInformation(staff);
        return "redirect:/Staff/ShowInfo?id="+id;
    }

    /**
     * 更新密码
     *
     * @param password1 第一次输入的密码
     * @param password2 第二次输入的密码
     * @param session session
     */
    @RequestMapping("/changePassword")
    public String updatePassword(String password1, String password2, HttpSession session, Model model) {
        if (password1.equals(password2)) {
            Staff staff = (Staff) session.getAttribute("staff");
            staffService.updatePassword(staff.getId(), password1);
            return "redirect:/Staff/ShowInfo?id="+staff.getId();
        } else {
            String error = "Change Failed";
            model.addAttribute("ERROR",error);
            return "/Staff/StaffEdit";
        }

    }


    /**
     * 计算所得税
     *
     * @return 某年的个人所得税
     */
    @RequestMapping("/tax")
    public String calculateTax(Model model, int year, HttpSession session) {
        long id = (long) session.getAttribute("staff");
        model.addAttribute("tax",staffService.calculateTax(id,year));
        return "/Staff/ShowInfo";
    }

}
