package com.baizhi.controller;

import com.baizhi.dto.Number2Dto;
import com.baizhi.dto.NumberDto;
import com.baizhi.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("number")
public class NumberController {
    @Autowired
    private NumberService numberService;
    @RequestMapping("getNumber")
    public NumberDto getNumber(){
        NumberDto number = numberService.getNumber();
        return number;
    }

    @RequestMapping("getNumber2")
    public List<Number2Dto> getNumber2(){
        List<Number2Dto> number2 = numberService.getNumber2();
        return number2;
    }
    @RequestMapping("getNumber3")
    public List<Number2Dto> getNumber3(){
        List<Number2Dto> number3 = numberService.getNumber3();
        return number3;
    }
    @RequestMapping("getNumber4")
    public List<Number2Dto> getNumbe42(){
        List<Number2Dto> number4 = numberService.getNumber4();
        return number4;
    }


}
