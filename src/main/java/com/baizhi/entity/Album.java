package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelTarget(value="专辑")
public class Album {
    @Id
    @ExcelIgnore
    private String id;
    @Excel(name="标题",needMerge = true)
    private String title;
    @Excel(name="数量",needMerge = true)
    private Integer count;
    @Excel(name="封面图片",type = 2,width=20,height=40)
    private String covreImg;
    @Excel(name="评分",needMerge = true)
    private Integer score;
    @Excel(name="作者",needMerge = true)
    private String author;
    @Excel(name="播音",needMerge = true)
    private String broadcast;
    @Excel(name="描述",needMerge = true)
    private String brief;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @Excel(name="发布时间",needMerge = true,format = "yyyy年MM月dd日")
    private Date pubDate;
    @ExcelCollection(name ="音频")
    private List<Chapter> children;

}
