package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
//import java.io.IOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //用户查询
    @Override
    public ResultVo getlist(Integer pageNum, Integer pageSize, Long id) {
        List<User> users;

        ResultVo resultVo ;

        try {
            if (id == null) {
                PageHelper.startPage(pageNum,pageSize);

                users = userMapper.selectByExample(null);
            }else {
                User user = userMapper.selectByPrimaryKey(id);
                users = new ArrayList<>();
                users.add(user);
            }

            PageInfo<User> pageInfo = new PageInfo<>(users);

            DataVo<User> dataVo = new DataVo<>(pageInfo.getTotal(),users,pageNum,pageSize);

            resultVo = new ResultVo(200, "用户获取成功", true, dataVo);


        }catch (Exception e) {
            resultVo = new ResultVo(500, "用户获取失败", false, null);

        }

        return resultVo;
    }

    //用户添加
    @Override
    public ResultVo add(User user) {


        if (user.getCreateTime() == null) {
              user.setCreateTime(new Date());
        }
        int affectedRows = userMapper.insertSelective(user);

        ResultVo resultVo;

        if (affectedRows > 0 ) {
           resultVo = new ResultVo(200,"用户添加成功",true, user);
        }else {
            resultVo = new ResultVo(500,"用户添加失败",false, null);
        }


        return resultVo;
    }

    //用户修改
    @Override
    public ResultVo update(User user) {

        int affectedRows = userMapper.updateByPrimaryKeySelective(user);

        ResultVo resultVo;

        if (affectedRows > 0) {
            User result = userMapper.selectByPrimaryKey(user.getId());

           resultVo = new ResultVo(200, "用户修改成功", true, result);
        }else {
            resultVo = new ResultVo(500, "用户修改失败", false, null);

        }

        return resultVo;
    }

    //用户删除
    @Override
    public ResultVo delete(Long id) {

        int affectedRows = userMapper.deleteByPrimaryKey(id);

        ResultVo resultVo;

        if (affectedRows > 0) {

            resultVo = new ResultVo(200, "OK", true, null);
        }else {
            resultVo = new ResultVo(500, "用户删除失败", false, null);

        }

        return resultVo;
    }


}

