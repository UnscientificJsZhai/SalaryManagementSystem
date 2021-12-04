package cn.edu.nwpu.salarymanagementsystem.controller;

import cn.edu.nwpu.salarymanagementsystem.service.AdministratorService;
import cn.edu.nwpu.salarymanagementsystem.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
     * @param id       用户ID
     * @param password
     * @param session
     */
    @RequestMapping("/login")
    public String processLogin(@RequestParam(value = "id", defaultValue = "") Long id,
                               @RequestParam(value = "password", defaultValue = "") String password,
                               HttpSession session, HttpServletResponse res) {
        //TODO 无法实现自由选择是否保存，先写成全部保留的方式
        if (administratorService.login(id, password)) {
            session.setAttribute("administrator", id);
            Cookie cookie1 = new Cookie("name", id.toString());
            cookie1.setMaxAge(24 * 60 * 60);
            res.addCookie(cookie1);
            Cookie cookie2 = new Cookie("password", password);
            cookie1.setMaxAge(24 * 60 * 60);
            res.addCookie(cookie2);
            res.addCookie(cookie2);
            return "redirect:/Admin/AdminView";
        } else if (staffService.login(id, password)) {
            session.setAttribute("staff", id);
            Cookie cookie1 = new Cookie("name", id.toString());
            cookie1.setMaxAge(24 * 60 * 60);
            res.addCookie(cookie1);
            Cookie cookie2 = new Cookie("password", password);
            cookie1.setMaxAge(24 * 60 * 60);
            res.addCookie(cookie2);
            res.addCookie(cookie2);
            return "redirect:/Staff/ShowInfo";
        } else {
            return "../Login";
        }

    }


}
