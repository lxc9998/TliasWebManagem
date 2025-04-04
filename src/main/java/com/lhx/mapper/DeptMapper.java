package com.lhx.mapper;

import com.lhx.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    List<Dept> findAll();

    void delDept(Integer id);

    void addDept(Dept dept);

    String getDeptInfo(Integer deptId);

    void updateDept(Dept dept);
}
