package cn.edu.nwpu.salarymanagementsystem.controller;

import cn.edu.nwpu.salarymanagementsystem.dao.AdministratorMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.StaffMapper;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.administrator.Administrator;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import cn.edu.nwpu.salarymanagementsystem.service.AdministratorService;
import cn.edu.nwpu.salarymanagementsystem.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @ClassName SalarySystem
 * @Description 网上薪酬系统的登陆控制器
 * @Author xuLyi
 * @Version 1.0
 */


@Controller
public class SalarySystem {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private StaffService staffService;

    /**
     * 登录请求
     *
     * @param Id
     * @param password
     * @param session
     */
    @RequestMapping("/login")
    public String processLogin(@RequestParam(value = "Id", defaultValue = "") long Id,
                               @RequestParam(value = "password", defaultValue = "") String password, HttpSession session) {

        if (administratorService.login(Id, password)) {
            session.setAttribute("administrator", administratorService);
            return "redirect:/shoustaff";
        } else if (staffService.login(Id, password)) {
            Staff staff = staffService.getPersonalInformation(Id);
            session.setAttribute("staff", staff);
            return "redirect:/showinfo";
        } else {
            return "redirect:/Login";
        }

    }


}
