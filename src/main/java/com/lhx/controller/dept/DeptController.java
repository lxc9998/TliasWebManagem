package com.lhx.controller.dept;

import com.lhx.pojo.Dept;
import com.lhx.pojo.Result;
import com.lhx.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/getDeptList")
    public Result list(){
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    // 新增部门
    @PostMapping("/addDept")
    public Result addDept(@RequestBody Dept dept){
        deptService.addDept(dept);
        return Result.success();
    }

    @PostMapping("/delDeptById")
    public Result delDeptById(Integer id){
        deptService.delDeptById(id);
        return Result.success();
    }
}
