package com.fc.controller;

import com.fc.entity.VolunteerRecruitment;
import com.fc.service.VolunteerService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("volunteer")
public class VolunteerController {
    @Autowired
    private VolunteerService volunteerService;

    @GetMapping("getlist")
    public ResultVo getlist(@RequestParam(value = "pageNum" ,defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize" ,defaultValue = "3" ) Integer pageSize,
                            Long id) {
        return volunteerService.getlist(pageNum,pageSize,id);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody VolunteerRecruitment volunteerRecruitment) {
        return volunteerService.add(volunteerRecruitment);
    }

    @PostMapping("update")
    public ResultVo update ( @RequestBody VolunteerRecruitment volunteerRecruitment) {
        return volunteerService.update(volunteerRecruitment);
    }

    @GetMapping("delete")
    public ResultVo delete(Long id) {
        return volunteerService.delete(id);
    }

}
