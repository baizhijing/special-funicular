package com.bzj.graduation.controller;
import com.bzj.graduation.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
            session.setAttribute("loginUser", username);
            return "index";
        }
        //登录失败
        else{
            //登陆失败
            map.put("msg","用户名密码错误");
            return  "login";
        }
    }
}
