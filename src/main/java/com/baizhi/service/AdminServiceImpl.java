package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper userMapper;
    @Override
    public String login(Admin a ,HttpSession session) {
        try {
            Admin admin = userMapper.selectOne(a);
            if (admin == null) throw new RuntimeException("用户名或密码错误");
            session.setAttribute("admin",admin);
            return "ok";
        }catch(Exception e){
           return e.getMessage();
        }
    }
}
