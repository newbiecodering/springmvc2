package com.liao.springmvc.controller;

import com.liao.springmvc.exception.UserNotExistException;
import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class Hello {
    @ResponseBody
    @RequestMapping("/aaa")
    public String a(){
        return "abcdef";
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "user",defaultValue = "b") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "hello";
    }

//    @RequestMapping("/")
    public String first(){
        return "login";
    }

    @PostMapping("/dashboard")
    public String dashboard(@RequestParam("username") String username, @RequestParam("password") String password,
                            Map<String,String> map, HttpSession session) {

        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
           session.setAttribute("username",username);
            return "redirect:/main.html";
        } else {
            map.put("msg","用户名或密码错误");
            return "login";
        }

    }
}
