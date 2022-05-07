package com.fc.service;

import com.fc.entity.User;
import com.fc.vo.ResultVo;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public interface UserService {
    //用户查询
    ResultVo getlist(Integer pageNum, Integer pageSize, Long id);

    //用户添加
    ResultVo add(User user);

    //用户修改
    ResultVo update(User user);

    //用户删除
    ResultVo delete(Long id);


}
