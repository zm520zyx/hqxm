package com.baizhi.controller;

import com.baizhi.dto.BannerDto;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @RequestMapping("getAll")
    public BannerDto getAll(int page, int rows){
        return bannerService.queryByPage(page,rows);
    }
    @RequestMapping("update")
    public  void uptdate(Banner banner){
        bannerService.update(banner);
    }
    @RequestMapping("add")
    public  void add(Banner banner, HttpSession session, MultipartFile file) throws IOException {
        ServletContext ctx = session.getServletContext();
        String realpath= ctx.getRealPath("/shouye");
        File file1 = new File(realpath+"/"+file.getOriginalFilename());
        file.transferTo(file1);
        banner.setImgPath("/shouye/"+file.getOriginalFilename());
        bannerService.add(banner);
    }

    @RequestMapping("delete")
    public  void delete(Integer id){
        bannerService.delete(id);
    }


}
