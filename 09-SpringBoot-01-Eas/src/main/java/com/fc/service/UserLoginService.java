package com.fc.service;

import com.fc.entity.Userlogin;
import com.fc.vo.ResultVo;

public interface UserLoginService {


    ResultVo login(String username, String password);
}
