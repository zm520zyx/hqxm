package com.baizhi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.dto.AlbumDto;
import com.baizhi.entity.Album;

import com.baizhi.service.AlbumService;

import com.github.pagehelper.PageHelper;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @RequestMapping("getAll")
    public AlbumDto getAll(int page, int rows){
        AlbumDto albumDto=new AlbumDto();
        PageHelper.startPage(page, rows);
        List<Album> all = albumService.getAll();
        int i=albumService.getCount()+10;
        albumDto.setTotal(i);
        albumDto.setRows(all);
        return albumDto;
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
    @RequestMapping("outport")
    public  void outport(){
        List<Album> all = albumService.getAll();
        for (int i = 0; i < all.size(); i++) {
            String path=all.get(i).getCovreImg();
             all.get(i).setCovreImg("D:/Source/spring-boot-hqxm/cmfz/src/main/webapp"+path);
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("专辑详情", "表格1"), Album.class, all);
        try {
            workbook.write(new FileOutputStream(new File("D:/a.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
