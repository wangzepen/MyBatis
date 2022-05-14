package com.fc.service;

import com.fc.entity.TbUser;
import com.fc.vo.ResultVo;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public interface UserService {

    ResultVo login(String username, String password);


    ResultVo update(MultipartFile img, TbUser user);
}
