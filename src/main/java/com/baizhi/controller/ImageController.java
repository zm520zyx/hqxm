package com.baizhi.controller;

import com.baizhi.conf.CreateValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("image")
public class ImageController {
    @RequestMapping("img")
    public void img(HttpServletResponse response,HttpSession session)throws Exception{
        // 画一张随机图片 --- 使用工具类的write方法画图片
        CreateValidateCode cvc = new CreateValidateCode();
        //获取图片上的随机数  --- 存档  --- session
        String code = cvc.getCode();
        session.setAttribute("code", code);
        //在输出图片
        cvc.write(response.getOutputStream());

    }

}
