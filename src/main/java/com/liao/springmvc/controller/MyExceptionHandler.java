package com.liao.springmvc.controller;

import com.liao.springmvc.exception.UserNotExistException;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    //无法自适应定制错误页面
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String,Object> handlerUserExp(Exception e){
//        Map<String, Object> map = new HashMap<>();
//        map.put("code","user.notEXIST");
//        map.put("message",e.getMessage());
//        return map;
//    }
//
    @ExceptionHandler(UserNotExistException.class)
    public String  handlerUserExp(Exception e, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        map.put("code","user.notEXIST");
        map.put("message",e.getMessage());
        request.setAttribute("javax.servlet.error.status_code",500);
        request.setAttribute("map",map);
        System.out.println("--error:"+map);
        return "forward:/error";
    }
}
