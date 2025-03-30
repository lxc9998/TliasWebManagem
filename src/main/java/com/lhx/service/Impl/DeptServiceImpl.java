package com.lhx.service.Impl;

import com.lhx.exception.BusinessException;
import com.lhx.mapper.DeptMapper;
import com.lhx.pojo.Dept;
import com.lhx.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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
        try {
            deptMapper.addDept(dept);
        } catch (Exception e) {
            if (e.getMessage().contains("Duplicate entry") && e.getMessage().contains("for key 'dept.dept_name'")) {
                log.error("发生SQL异常:", e);
                throw new BusinessException("部门名称已存在"); // 将技术异常转为自定义业务异常,并由全局异常处理器进行处理
            } else {
                throw new RuntimeException("操作失败,请联系管理员进行处理");
            }
        }
    }
}
