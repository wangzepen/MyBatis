package com.fc.controller;

import com.fc.entity.Userlogin;
import com.fc.service.UserLoginService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;

    //登录跳转
    @GetMapping("login")
    public String login()  {
        return "../../login";
    }


    @PostMapping("login")
    public ResultVo login(Userlogin userlogin) {
        return userLoginService.login(userlogin.getUsername(),userlogin.getPassword());
    }
}
