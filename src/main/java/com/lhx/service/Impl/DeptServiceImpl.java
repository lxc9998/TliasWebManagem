package com.lhx.service.Impl;

import com.lhx.mapper.DeptMapper;
import com.lhx.pojo.Dept;
import com.lhx.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void delDeptById(Integer id) {
        deptMapper.delDeptById(id);
    }

    @Override
    public void addDept(Dept dept) {
        deptMapper.addDept(dept);
    }
}
