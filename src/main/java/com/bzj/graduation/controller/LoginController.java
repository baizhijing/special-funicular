package com.bzj.graduation.controller;
import com.bzj.graduation.bean.User;
import com.bzj.graduation.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author:bai
 * @data:2019/3/7
 **/
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session)
    {
        if(!StringUtils.isEmpty(username) && loginService.LoginIsTrue(username,password)) {
            //登陆成功，防止表单重复提交，可以重定向到主页
            int userId=loginService.getUserId(username);
            session.setAttribute("userId",userId);
            session.setAttribute("loginUser", username);
            User user=loginService.getUserByUserName(username);
            if (user.getType()==2)
            return "index";
            else
                return "indexManager";
        }
        //登录失败
        else{
            //登陆失败
            map.put("msg","用户名密码错误");
            return  "login";
        }
    }

    @PostMapping("/user/regist")
    public String regist(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         Map<String,Object> map, HttpSession session){
        if (loginService.ifExitUsername(username)) {
            map.put("msg", "此用户名已存在");
            return "regist";
        }
        else{
            loginService.addUser(username,password);
            map.put("msg","注册成功");
            session.setAttribute("loginUser",username);
            session.setAttribute("integ",1);
            return "index";
        }
    }

    @ResponseBody
    @GetMapping("/getLoginUserMsg")
    public User getLoginUserMsg(HttpSession session){
        String username=(String)session.getAttribute("loginUser");
        return loginService.getUserByUserName(username);
    }

    @ResponseBody
    @GetMapping("/getLoginUserId")
    public Integer getLoginUserId(HttpSession session){
        String username=(String)session.getAttribute("loginUser");
        return loginService.getUserId(username);
    }
}
