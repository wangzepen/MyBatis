package com.fc.controller;

import com.fc.entity.Alleviation;
import com.fc.service.AlleviationService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("alleviation")
@CrossOrigin("*")
public class AlleviationController {
    @Autowired
    private AlleviationService alleviationService;

    @GetMapping("getlist")
    public ResultVo getlist(@RequestParam(value = "pageNum" ,defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize" ,defaultValue = "3" ) Integer pageSize,
                            Long id) {
        return alleviationService.getlist(pageNum,pageSize,id);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody Alleviation alleviation) {
        return alleviationService.add(alleviation);
    }

    @PostMapping("update")
    public ResultVo update ( @RequestBody Alleviation alleviation) {
        return alleviationService.update(alleviation);
    }

    @GetMapping("delete")
    public ResultVo delete(Long id) {
        return alleviationService.delete(id);
    }

}
