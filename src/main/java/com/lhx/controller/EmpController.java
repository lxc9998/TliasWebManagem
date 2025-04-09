package com.lhx.controller;

import com.lhx.pojo.Emp;
import com.lhx.pojo.Result;
import com.lhx.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result getEmpList(Integer pageNum,Integer pageSize){
        log.info("前端传参:页码{},每页数量{}",pageNum,pageSize);
        List<Emp> empList = empService.getEmpList(pageNum,pageSize);
        return Result.success(empList);
    }
}
