package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chapter {
    @Id
    @KeySql(useGeneratedKeys = true)
    @Excel(name="编号")
    private Integer id;
    @Excel(name="标题")
    private String title;
    @Excel(name="大小")
    private String size;
    @Excel(name="时长")
    private String duration;
    @Excel(name="路径")
    private String url;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @Excel(name="上传时间",format = "yyyy年MM月dd日")
    private Date uploadDate;
    @ExcelIgnore
    private String aid;
}
