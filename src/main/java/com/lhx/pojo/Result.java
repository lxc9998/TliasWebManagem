package com.lhx.pojo;

import lombok.Data;

@Data
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public static Result success(){
        Result result = new Result();
        result.code = 1;
        result.msg = "success";
        return result;
    }

    // 1、如果传对象那就给data
    public static Result success(Object data){
        Result result = success();
        result.data = data;
        return result;
    }

    // 2、如果传string那就是msg
    public static Result error(String msg){
        Result result = new Result();
        result.code = 0;
        result.msg = msg;
        return result;
    }
}
