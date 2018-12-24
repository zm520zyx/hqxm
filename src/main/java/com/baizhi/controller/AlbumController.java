package com.baizhi.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.baizhi.entity.Album;
import com.baizhi.entity.Banner;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @RequestMapping("getAll")
    public List<Album>  getAll(){
        List<Album> all = albumService.getAll();
        return all;
    }

    @RequestMapping("getOne")
    public Album  getOne(String id){
        System.out.println(id);
        Album one = albumService.getOne(id);
        System.out.println(one);
        return one;
    }

    @RequestMapping("add")
    public  void add(Album album, HttpSession session, MultipartFile file) throws IOException {
        ServletContext ctx = session.getServletContext();
        String realpath= ctx.getRealPath("/albumImg");
        File file1 = new File(realpath+"/"+file.getOriginalFilename());
        file.transferTo(file1);
        album.setCovreImg("/albumImg/"+file.getOriginalFilename());
        albumService.add(album);
    }
}
