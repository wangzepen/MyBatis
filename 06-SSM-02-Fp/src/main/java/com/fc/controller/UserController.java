package com.fc.controller;



import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    //用户查询
    @GetMapping("getlist")
    public ResultVo getlist( @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize,
                             Long id) {
        return userService.getlist(pageNum,pageSize,id);

    }
    //用户添加
    @PostMapping("add")
    public ResultVo add(@RequestBody User user) {
      return userService.add(user);
    }

    //用户修改
    @PostMapping("update")
    public ResultVo update(@RequestBody User user) {
        return userService.update(user);
    }
   //用户删除
    @GetMapping("delete")
    public ResultVo delete(Long id) {
       return userService.delete(id);
    }




}
