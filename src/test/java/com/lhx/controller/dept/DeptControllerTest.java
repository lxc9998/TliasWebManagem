package com.lhx.controller.dept;

import com.lhx.pojo.Dept;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class DeptControllerTest {

    @Autowired
    DeptController deptController;

    @DisplayName("模拟前端传入数据")
    @Test
    void addDept() {
        deptController.addDept(Dept.builder().deptName("单元测试部门2").build());
    }

}