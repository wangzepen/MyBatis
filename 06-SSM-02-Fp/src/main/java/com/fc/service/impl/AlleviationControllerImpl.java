package com.fc.service.impl;

import com.fc.dao.AlleviationMapper;
import com.fc.entity.Alleviation;
import com.fc.service.AlleviationService;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AlleviationControllerImpl implements AlleviationService {
    @Autowired
    private AlleviationMapper alleviationMapper;

    @Override
    public ResultVo getlist(Integer pageNum, Integer pageSize, Long id) {
        List<Alleviation> alleviations;

        ResultVo resultVo;

        try {
            if (id == null) {
                PageHelper.startPage(pageNum,pageSize);

                alleviations = alleviationMapper.selectByExample(null);
            }else {
                Alleviation alleviation = alleviationMapper.selectByPrimaryKey(id);

                alleviations = new ArrayList<>();
                alleviations.add(alleviation);
            }

            PageInfo<Alleviation> pageInfo = new PageInfo<>(alleviations);

            DataVo<Alleviation> dataVo = new DataVo<>(pageInfo.getTotal(),alleviations,pageNum,pageSize);

            resultVo = new ResultVo(200, "扶贫政策项目获取成功", true, dataVo);

        }catch (Exception e) {

            resultVo = new ResultVo(500, "扶贫政策项目获取失败", false, null);

        }

        return resultVo;
    }

    @Override
    public ResultVo add(Alleviation alleviation) {

        if (alleviation.getCreateTime()== null) {
            alleviation.setCreateTime(new Date());
        }
        int affectedRows = alleviationMapper.insertSelective(alleviation);

        ResultVo resultVo;

        if (affectedRows > 0 ) {
            resultVo = new ResultVo(200,"扶贫项目添加成功",true, alleviation);
        }else {
            resultVo = new ResultVo(500,"扶贫项目添加失败",false, null);
        }


        return resultVo;
    }

    @Override
    public ResultVo update(Alleviation alleviation) {
        int affectedRows =  alleviationMapper.updateByPrimaryKeySelective(alleviation);

        ResultVo resultVo;

        if (affectedRows > 0) {
            Alleviation result = alleviationMapper.selectByPrimaryKey(alleviation.getId());

            resultVo = new ResultVo(200, "扶贫项目修改成功", true, result);
        }else {
            resultVo = new ResultVo(500, "扶贫项目修改失败", false, null);

        }

        return resultVo;
    }

    @Override
    public ResultVo delete(Long id) {
        int affectedRows = alleviationMapper.deleteByPrimaryKey(id);

        ResultVo resultVo;

        if (affectedRows > 0) {

            resultVo = new ResultVo(200, "扶贫项目删除成功", true, null);
        }else {
            resultVo = new ResultVo(500, "扶贫项目删除失败", false, null);

        }

        return resultVo;
    }
    }

