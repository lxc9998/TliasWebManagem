package com.lhx.service;

import com.lhx.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> findAll();

    void delDeptById(Integer id);

    void addDept(Dept dept);
}
