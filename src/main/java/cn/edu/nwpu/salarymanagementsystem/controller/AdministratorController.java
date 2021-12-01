package cn.edu.nwpu.salarymanagementsystem.controller;

import cn.edu.nwpu.salarymanagementsystem.dao.StaffMapper;
import cn.edu.nwpu.salarymanagementsystem.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @ClassName AdministratorController
 * @Description 管理员控制器
 * @Author xuLyi
 * @Version 1.0
 */
@Controller
@RequestMapping("/administrator")
public class AdministratorController {

    private AdministratorService administratorService;

    @Autowired
    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

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

    @RequestMapping(value = "/showStaff", method = GET)
    public String showAllStaff(){
        //TODO
        return null;
    }

    public String addStaff(String staffName, String password) {
        //TODO
        return null;
    }
    public String removeStaff(String Id) {
        //
        return null;
    }
}
