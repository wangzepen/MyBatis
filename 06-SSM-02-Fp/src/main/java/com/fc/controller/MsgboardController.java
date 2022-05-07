package com.fc.controller;

import com.fc.entity.Collection;
import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MsgboardService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("msgboard")
@CrossOrigin("*")
public class MsgboardController {
    @Autowired
    private MsgboardService msgboardService;
    @GetMapping("getlist")
    public ResultVo getlist(@RequestParam(value = "pageNum" ,defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize" ,defaultValue = "3" ) Integer pageSize,
                            Long id) {
        return msgboardService.getlist(pageNum,pageSize,id);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody MessageBoardWithBLOBs messageBoard) {
        return msgboardService.add(messageBoard);
    }

    @PostMapping("update")
    public ResultVo update ( @RequestBody MessageBoardWithBLOBs messageBoard) {
        return msgboardService.update(messageBoard);
    }

    @GetMapping("delete")
    public ResultVo delete(Long id) {
        return msgboardService.delete(id);
    }
}
