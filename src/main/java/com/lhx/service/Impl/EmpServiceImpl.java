package com.lhx.service.Impl;

import com.lhx.mapper.EmpMapper;
import com.lhx.pojo.Emp;
import com.lhx.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> getEmpList(Integer pageNum, Integer pageSize) {
        return empMapper.getEmpList(pageNum,pageSize);
    }
}
