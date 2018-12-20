package com.baizhi.dto;

import com.baizhi.entity.Banner;

import java.util.List;

public class BannerDto {
    private Integer total;
    private List<Banner> rows;

    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public List<Banner> getRows() {
        return rows;
    }
    public void setRows(List<Banner> rows) {
        this.rows = rows;
    }
}
