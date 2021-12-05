package cn.edu.nwpu.salarymanagementsystem.controller;

import cn.edu.nwpu.salarymanagementsystem.service.AdministratorService;
import cn.edu.nwpu.salarymanagementsystem.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 网上薪酬系统的登陆控制器。
 *
 * @Author xuLyi
 */
@Controller
public class SalarySystem {

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

    /**
     * 登录请求
     *
     * @param id       用户ID。
     * @param password 密码。
     * @param session  session。
     */
    @RequestMapping("/login")
    public String processLogin(@RequestParam(value = "id", defaultValue = "") Long id,
                               @RequestParam(value = "password", defaultValue = "") String password,
                               @RequestParam(value = "remember", defaultValue = "") String remember,
                               Model model,
                               HttpSession session, HttpServletResponse res) {
        //TODO 无法实现自由选择是否保存，先写成全部保留的方式
        if (administratorService.login(id, password)) {
            session.setAttribute("administrator", administratorService.getAdministratorInfo(id, password));
            setCookie(id, password, remember, res);
            return "redirect:/Admin/showStaff";
        } else if (staffService.login(id, password)) {
            session.setAttribute("staff", staffService.getPersonalInformation(id));
            setCookie(id, password, remember, res);
            return "redirect:/Staff/ShowInfo";
        } else {
            model.addAttribute("result", "登录错误！");
            return "/wa";
        }
    }

    /**
     * 登录成功后为Cookie传值。
     *
     * @param id       用户的id。
     * @param password 密码。
     * @param remember 是否记住。
     * @param res      Http响应。
     */
    private void setCookie(Long id, String password, String remember, HttpServletResponse res) {
        if ("remember-me".equals(remember)) {
            Cookie cookie1 = new Cookie("name", id.toString());
            cookie1.setMaxAge(24 * 60 * 60);
            res.addCookie(cookie1);
            Cookie cookie2 = new Cookie("password", password);
            cookie1.setMaxAge(24 * 60 * 60);
            res.addCookie(cookie2);
            res.addCookie(cookie2);
        }
    }

    /**
     * 登出。
     *
     * @param session session。
     * @return 回到登录页面。
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        if (session.getAttribute("administrator") != null) {
            session.removeAttribute("administrator");
        }
        if (session.getAttribute("staff") != null) {
            session.removeAttribute("staff");
        }
        return "sign-in";
    }
}
