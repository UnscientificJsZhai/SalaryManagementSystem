package cn.edu.nwpu.salarymanagementsystem.controller;

import cn.edu.nwpu.salarymanagementsystem.dao.AdministratorMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.StaffMapper;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.administrator.Administrator;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @ClassName HomeController
 * @Description 网上薪酬系统的主页控制器
 * @Author xuLyi
 * @Version 1.0
 */


@Controller
@RequestMapping("/Login")
public class HomeController {

    private AdministratorMapper administratorMapper;

    private StaffMapper staffMapper;

    @Autowired
    public HomeController(AdministratorMapper administratorMapper, StaffMapper staffMapper) {
        this.administratorMapper = administratorMapper;
        this.staffMapper = staffMapper;
    }

    /**
     * 返回首页
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "Login";
    }

    /**
     * 登录请求
     *
     * @param Id
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/Login", method = POST)
    public String processLogin(@RequestParam(value = "Id", defaultValue = "") String Id,
                               @RequestParam(value = "password", defaultValue = "") String password, HttpSession session) {

        Staff staff = staffMapper.login(Id, password);
        Administrator administrator = administratorMapper.login(Id, password);
        if (administrator != null) {
            session.setAttribute("administrator", administrator);
            return "redirect:/administrator";
        } else if (staff != null) {
            session.setAttribute("staff", staff);
            return "redirect:/staff";
        } else {
            return "Login";
        }

    }


}
