package com.lhx.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor  // 给mybatis使用
@AllArgsConstructor // Builder模式需要
@Builder    // 支持部分字段初始化,例如id字段一般不需要初始化
public class Dept {
    private Integer id;
    private String deptName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")    // LocalDateTime的时间中间有T,需要格式化
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
