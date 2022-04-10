package com.fc.service;

import com.fc.entity.Alleviation;
import com.fc.vo.ResultVo;

public interface AlleviationService {
    ResultVo getlist(Integer pageNum, Integer pageSize, Long id);

    ResultVo add(Alleviation alleviation);

    ResultVo update(Alleviation alleviation);

    ResultVo delete(Long id);
}
