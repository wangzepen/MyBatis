package com.fc.advice;

import com.fc.vo.ResultVo;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//对Controller进行增强
@ControllerAdvice
public class GlobalExceptionHandler {
    //对指定的异常进行捕获
    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody
    public ResultVo handleDuplicateKeyException(DuplicateKeyException e) {
        return new ResultVo(4000,"您的操作有误，当前用户已存在",false,e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResultVo handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new ResultVo(5000, "您的操作有误，请输入json格式的参数", false, e.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ResultVo handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return new ResultVo(6000, "您的操作有误，缺少了必要的参数", false, e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResultVo handleRuntimeException(RuntimeException e) {
        return new ResultVo(6000, "您的操作有误，请联系管理员", false, e.getMessage());
    }
}
