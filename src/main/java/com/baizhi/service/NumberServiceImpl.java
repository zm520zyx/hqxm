package com.baizhi.service;

import com.baizhi.dto.Number2Dto;
import com.baizhi.dto.NumberDto;
import com.baizhi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class NumberServiceImpl implements  NumberService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Number2Dto> getNumber3() {
        List<Number2Dto> number3 = userMapper.getNumber3();
        return  number3;
    }

    @Override
    public List<Number2Dto> getNumber4() {
        List<Number2Dto> number4 = userMapper.getNumber4();
        return  number4;
    }

    @Override
    public List<Number2Dto> getNumber2() {
        List<Number2Dto> number2 = userMapper.getNumber2();
        return  number2;
    }

    @Override
    public NumberDto getNumber() {
        NumberDto numberDto=new NumberDto();
        List<Integer> list =new ArrayList();
        list.add(userMapper.oneWeek());
        list.add(userMapper.twoWeek());
        list.add(userMapper.threeWeek());
        list.add(userMapper.fourWeek());
        list.add(userMapper.fiveWeek());
        numberDto.setData(list);
        return numberDto;
    }
}
