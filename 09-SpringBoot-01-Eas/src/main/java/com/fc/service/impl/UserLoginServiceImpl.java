package com.fc.service.impl;

import com.fc.dao.UserloginMapper;
import com.fc.entity.Userlogin;
import com.fc.entity.UserloginExample;
import com.fc.service.UserLoginService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserloginMapper userloginMapper;

    @Override
    public ResultVo login(String username , String password) {

        UserloginExample example = new UserloginExample();

        ResultVo vo = new ResultVo();

        UserloginExample.Criteria criteria = example.createCriteria();

        criteria.andUsernameEqualTo(username);

        criteria.andPasswordEqualTo(password);


        if () {

        }

        return vo;
    }
}
