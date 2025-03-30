package com.lhx.controller.dept;

import com.lhx.pojo.Dept;
import com.lhx.pojo.Result;
import com.lhx.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/getDeptList")
    public Result getDeptList(){
        List<Dept> deptList = deptService.findAll();
        log.info("查询到的部门列表为：{}",deptList);
        return Result.success(deptList);
    }

    // 新增部门
    @PostMapping("/addDept")
    public Result addDept(@RequestBody Dept dept){
        log.info("前端入参：{}",dept);
        deptService.addDept(dept);
        return Result.success();
    }

    @PostMapping("/delDeptById")
    public Result delDeptById(Integer id){
        deptService.delDeptById(id);
        return Result.success();
    }
}
