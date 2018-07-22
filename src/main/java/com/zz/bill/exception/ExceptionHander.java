package com.zz.bill.exception;

import com.zz.bill.util.CommonCode;
import com.zz.bill.model.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHander {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult handle (Exception e){
        if (e instanceof UserException){
            return JsonResult
                    .builder()
                    .code(((UserException) e).getCode())
                    .msg(e.getMessage())
                    .build();
        }else{
            return JsonResult
                    .builder()
                    .code(CommonCode.SYS_ERR.getCode())
                    .msg(CommonCode.SYS_ERR.getMessage() + "，具体原因："+e.getMessage())
                    .build();
        }
    }
}