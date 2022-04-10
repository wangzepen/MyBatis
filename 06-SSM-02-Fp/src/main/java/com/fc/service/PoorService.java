package com.fc.service;

import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.vo.ResultVo;

public interface PoorService {
    ResultVo getlist(Integer pageNum, Integer pageSize, Long id);

    ResultVo add(PoorWithBLOBs poor);

    ResultVo update(PoorWithBLOBs poor);

    ResultVo delete(Long id);

}
