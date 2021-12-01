package cn.edu.nwpu.salarymanagementsystem.controller;

import cn.edu.nwpu.salarymanagementsystem.dao.SalaryMapper;
import cn.edu.nwpu.salarymanagementsystem.dao.StaffMapper;
import cn.edu.nwpu.salarymanagementsystem.pojo.data.staff.Staff;
import cn.edu.nwpu.salarymanagementsystem.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @ClassName StaffController
 * @Description 员工控制器
 * @Author xuLyi
 * @Version 1.0
 */
@Controller
@RequestMapping("/staff")
public class StaffController {

    private StaffMapper staffMapper;
    private SalaryMapper salaryMapper;
    private StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService,
                           StaffMapper staffMapper, SalaryMapper salaryMapper) {
        this.staffService = staffService;
        this.staffMapper = staffMapper;
        this.salaryMapper = salaryMapper;
    }

    /**
     * 员工注销
     *
     * @param session
     * @return Login
     */
    @RequestMapping(value = "/logout", method = GET)
    public String logout(HttpSession session) {
        session.removeAttribute("staff");
        session.invalidate();
        return "redirect:/Login";
    }

    /**
     * 更新用户个人信息
     * @param name
     * @param phoneNumber
     * @param email
     * @return
     */
    public String updatePersonalInformation(String name,
                                            String phoneNumber, String email, HttpSession session) {
        Staff staff = staffMapper.queryByUserName(session.getAttribute("staff"))

    }
}
