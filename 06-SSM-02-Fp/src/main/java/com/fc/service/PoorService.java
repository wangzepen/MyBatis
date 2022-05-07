package com.fc.service;

import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.vo.ResultVo;

import java.util.Date;

public interface PoorService {
    ResultVo click(Long id, Date lastClickTime);

    ResultVo getlist(Integer pageNum, Integer pageSize, Long id);

    ResultVo add(PoorWithBLOBs poor);

    ResultVo update(PoorWithBLOBs poor);

    ResultVo delete(Long id);

}
