package com.lhx.service;

import com.lhx.pojo.Emp;

import java.util.List;

public interface EmpService {

    List<Emp> getEmpList(Integer pageNum, Integer pageSize);

}
