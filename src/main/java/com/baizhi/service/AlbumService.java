package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Album;
import com.baizhi.entity.Banner;

import java.util.List;

public interface AlbumService {
   public List<Album> getAll();
   public Album getOne(String id);
   public void add(Album album);
}
