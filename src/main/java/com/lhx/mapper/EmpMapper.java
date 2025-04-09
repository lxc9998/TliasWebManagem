package com.lhx.mapper;

import com.lhx.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {
    List<Emp> getEmpList(Integer pageNum, Integer pageSize);
}
