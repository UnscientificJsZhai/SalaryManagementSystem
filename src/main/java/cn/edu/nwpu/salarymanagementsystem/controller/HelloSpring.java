package cn.edu.nwpu.salarymanagementsystem.controller;

import cn.edu.nwpu.salarymanagementsystem.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloSpring {

    @Autowired
    private StaffService staffService;

    @RequestMapping("/login")
    public String hello(String username, String password) {
        long id = Long.parseLong(username);
        if (staffService.login(id,password)){
            return "showinfo";
        }else {
            return "404";
        }
    }
}
