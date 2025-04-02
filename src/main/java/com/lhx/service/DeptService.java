package com.lhx.service;

import com.lhx.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> findAll();

    void delDept(Integer id);

    void addDept(Dept dept);

    String getDeptInfo(Integer deptId);

    void updateDept(Dept dept);
}
