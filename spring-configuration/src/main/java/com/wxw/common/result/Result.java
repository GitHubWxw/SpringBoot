package com.wxw.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：wxw.
 * @date ： 15:29 2020/12/9
 * @description：封装结果集
 * @link:
 * @version: v_0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -5699534038153137080L;
    private boolean success = false;
    private Integer code = -1;
    private String message;
    private T data;

    /**
     * 判断是否成功
     */
    public boolean isSuccess(){
        return this.success;
    }

    /**
     * 返回两个参数的构造方法
     */
    public Result(Integer code,String message){
        this(false,code,message,null);
    }

    // 成功的时候调用
    public  Result success(T data, String message){
        return new Result<T>(true,0,message,data);
    }
    // 成功不需要传入参时
    public  Result success(){
        return new Result<T>(true,0,"成功",null);
    }

    // 失败的时候调用
    public  Result fail(T data, String message){
        return new Result<T>(false,-1,message,data);
    }

    public  Result fail(String message){
        return new Result<T>(false,-1,message,null);
    }

}
