package cn.edu.nwpu.salarymanagementsystem.controller;

import cn.edu.nwpu.salarymanagementsystem.dao.StaffMapper;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.MutableStaff;
import cn.edu.nwpu.salarymanagementsystem.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @ClassName AdministratorController
 * @Description 管理员控制器
 * @Author xuLyi
 * @Version 1.0
 */
@Controller
//@RequestMapping("/administrator")
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
     * 添加员工
     *
     * @param staffName
     * @param password
     * @return
     */
    @RequestMapping("/addstaff")
    public String addStaff(String staffName, String password) {
        //TODO
        return null;
    }

    public String removeStaff(String Id) {
        //
        return null;
    }
}
