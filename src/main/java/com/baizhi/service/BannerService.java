package com.baizhi.service;

import com.baizhi.dto.BannerDto;
import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerService {
    public BannerDto queryByPage(int curPage, int pageSize);
    public void update(Banner banner);
    public void add(Banner banner);
    public void delete(Integer i);
}
