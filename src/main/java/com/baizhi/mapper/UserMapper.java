package com.baizhi.mapper;
import com.baizhi.dto.Number2Dto;
import com.baizhi.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    public Integer oneWeek();
    public Integer twoWeek();
    public Integer threeWeek();
    public Integer fourWeek();
    public Integer fiveWeek();
    public List<Number2Dto> getNumber2();
    public List<Number2Dto> getNumber3();
    public List<Number2Dto> getNumber4();
}
