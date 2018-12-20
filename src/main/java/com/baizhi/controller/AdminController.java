package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService userService;
    @RequestMapping("login")
    public String login(Admin admin ,String code,HttpSession session){
        String realcode=(String)session.getAttribute("code");
        if(!realcode.equals(code))return "验证码错误" ;
        String s=userService.login(admin,session);
        return s;
    }
}
