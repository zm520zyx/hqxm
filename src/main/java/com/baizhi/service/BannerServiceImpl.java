package com.baizhi.service;

import com.baizhi.dto.BannerDto;
import com.baizhi.entity.Banner;
import com.baizhi.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BannerServiceImpl implements  BannerService {
    @Autowired
    private BannerMapper bannerMapper;
    @Override
    public BannerDto queryByPage(int curPage, int pageSize) {
        List<Banner> banners = bannerMapper.selectByPage(curPage, pageSize);
        BannerDto dto = new BannerDto();
        dto.setTotal(bannerMapper.selectCount(new Banner()));
        dto.setRows(banners);
        return  dto;
    }

    @Override
    public void update(Banner banner) {
        bannerMapper.updateByPrimaryKey(banner);
    }

    public void add(Banner banner) {
        bannerMapper.insert(banner);
    }
    public void delete(Integer id) {
        bannerMapper.deleteByPrimaryKey(id);
    }

}
