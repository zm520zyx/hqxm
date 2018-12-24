package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.FileUtils;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.net.URLEncoder;


@RestController
@RequestMapping("chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("add")
    public  void add(Chapter chapter,String aid,HttpSession session, MultipartFile file) throws Exception {
        chapter.setAid(aid);
        System.out.println(chapter);
        ServletContext ctx = session.getServletContext();
        String realpath= ctx.getRealPath("/chaptermp3");
        File file1 = new File(realpath+"/"+file.getOriginalFilename());
        file.transferTo(file1);
        long size = file.getSize();
        long L=size/1024/1024;
        String ss=L+"M";
        chapter.setSize(ss);
        chapter.setUrl("/chaptermp3/"+file.getOriginalFilename());
        MP3File f = (MP3File) AudioFileIO.read(file1);
        MP3AudioHeader audioHeader = (MP3AudioHeader) f.getAudioHeader();
        String fileTimeLength = audioHeader.getTrackLengthAsString();
        if (fileTimeLength.length() < 7) {
            fileTimeLength = "00:" + fileTimeLength;

        }
        chapter.setDuration(fileTimeLength);
        chapterService .add(chapter);
    }
    @RequestMapping("download")
    public  void dawnload(String name, HttpSession session, HttpServletResponse response) {
   try {
       String realPath=session.getServletContext().getRealPath("/chaptermp3");
       String realName = name.replace("/chaptermp3/", "");
       byte[] bs= FileUtils.readFileToByteArray(new File(realPath+"/"+realName));
       response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(realName,"UTF-8"));
       ServletOutputStream outputStream=response.getOutputStream();
       outputStream.write(bs);
       if(outputStream!=null) outputStream.flush();
       if(outputStream!=null) outputStream.close();

   }catch (Exception e){
       e.printStackTrace();
   }
    }
}
