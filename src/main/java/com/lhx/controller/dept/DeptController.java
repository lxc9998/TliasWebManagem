package com.lhx.controller.dept;

import com.lhx.pojo.Dept;
import com.lhx.pojo.Result;
import com.lhx.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class DeptController {

    @Autowired
    private DeptService deptService;

    // 查询部门列表
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

    // 删除部门提取路径中的参数
    @PostMapping("/delDept")
    public Result delDept(@RequestBody Dept dept){
        log.info("前端入参：{}",dept);
        deptService.delDept(dept.getId());
        return Result.success();
    }

    // 查询部门名称
    @GetMapping("/getDeptInfo/{deptId}")
    public Result getDeptInfo(@PathVariable Integer deptId){
        String deptName = deptService.getDeptInfo(deptId);
        return Result.success(deptName);
    }

    // 更新部门名称
    @PostMapping("/updateDept")
    public Result updateDept(@RequestBody Dept dept){
        deptService.updateDept(dept);
        return Result.success();
    }
}
