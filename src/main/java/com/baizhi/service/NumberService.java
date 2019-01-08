package com.baizhi.service;

import com.baizhi.dto.Number2Dto;
import com.baizhi.dto.NumberDto;

import java.util.List;

public interface NumberService {
    public NumberDto getNumber();
    public List<Number2Dto> getNumber2();
    public List<Number2Dto> getNumber3();
    public List<Number2Dto> getNumber4();
}
