package com.baizhi.service;
import com.baizhi.entity.Album;
import com.baizhi.entity.Banner;
import com.baizhi.mapper.AlbumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService{
    @Autowired
    private  AlbumMapper albumMapper;
    @Override
    public List<Album> getAll() {
        List<Album> all = albumMapper.getAll();
        return  all;
    }

    @Override
    public Album getOne(String id) {
        Album album = albumMapper.selectByPrimaryKey(id);
        return album;
    }

    @Override
    public int getCount() {
        int i = albumMapper.selectCount(new Album());
        return  i;
    }

    public void add(Album album) {
        String id=UUID.randomUUID().toString().replace("-", "");
        album.setId(id);
        albumMapper.insert(album);
    }
}

