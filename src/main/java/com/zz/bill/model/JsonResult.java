package com.zz.bill.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zz.bill.util.CommonCode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//❤️ 保证序列化json的时候,如果是null的对象,key也会消失
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JsonResult<T> {

    private String code;
    private String msg;
    private T data;

    public JsonResult(String msg) {

        this.msg = msg;
    }

    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(){
    }

    public JsonResult(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static<T> JsonResult<T> createBySuccess(){
        return new JsonResult<>(CommonCode.SUCC.getCode());
    }

    public static<T> JsonResult<T> createBySuccessMessage(String msg){
        return new JsonResult<T>(CommonCode.SUCC.getCode(),msg);
    }

    public static<T> JsonResult<T> createBySuccess(String msg, T data){
        return new JsonResult<T>(CommonCode.SUCC.getCode(), msg, data);
    }

    public static<T> JsonResult<T> createBySuccess(T data){
        return new JsonResult<T>(CommonCode.SUCC.getCode(), CommonCode.SUCC.getMessage(), data);
    }

    public static<T> JsonResult<T> createByError(String code, String msg, T data){
        return new JsonResult<>(code, msg, data);
    }

    public static<T> JsonResult<T> createByErrorMsg(String msg){
        return new JsonResult<>(msg);
    }








}
