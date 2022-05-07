package com.fc.service.impl;

import com.fc.dao.VolunteerRecruitmentMapper;
import com.fc.entity.VolunteerRecruitment;
import com.fc.service.VolunteerService;
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
public class VolunteerServiceImpl implements VolunteerService {
    @Autowired
    private VolunteerRecruitmentMapper volunteerRecruitmentMapper;


    @Override
    public ResultVo getlist(Integer pageNum, Integer pageSize, Long id) {
        List<VolunteerRecruitment> volunteerRecruitments;

        ResultVo resultVo;

        try {
            if (id == null) {
                PageHelper.startPage(pageNum,pageSize);

                volunteerRecruitments = volunteerRecruitmentMapper.selectByExampleWithBLOBs(null);
            }else {
                VolunteerRecruitment volunteerRecruitment = volunteerRecruitmentMapper.selectByPrimaryKey(id);

                volunteerRecruitments = new ArrayList<>();
                volunteerRecruitments.add(volunteerRecruitment);
            }

            PageInfo<VolunteerRecruitment> pageInfo = new PageInfo<>(volunteerRecruitments);

            DataVo<VolunteerRecruitment> dataVo = new DataVo<>(pageInfo.getTotal(),volunteerRecruitments,pageNum,pageSize);

            resultVo = new ResultVo(200, "志愿者招聘获取成功", true, dataVo);

        }catch (Exception e) {

            resultVo = new ResultVo(500, "志愿者招聘获取失败", false, null);

        }

        return resultVo;
    }

    @Override
    public ResultVo add(VolunteerRecruitment volunteerRecruitment) {
        if (volunteerRecruitment.getCreateTime()== null) {
            volunteerRecruitment.setCreateTime(new Date());
        }
        int affectedRows = volunteerRecruitmentMapper.insertSelective(volunteerRecruitment);

        ResultVo resultVo;

        if (affectedRows > 0 ) {
            resultVo = new ResultVo(200,"志愿者招聘添加成功",true, volunteerRecruitment);
        }else {
            resultVo = new ResultVo(500,"志愿者招聘添加失败",false, null);
        }


        return resultVo;
    }

    @Override
    public ResultVo update(VolunteerRecruitment volunteerRecruitment) {
        int affectedRows =  volunteerRecruitmentMapper.updateByPrimaryKeySelective(volunteerRecruitment);

        ResultVo resultVo;

        if (affectedRows > 0) {
            VolunteerRecruitment result = volunteerRecruitmentMapper.selectByPrimaryKey(volunteerRecruitment.getId());

            resultVo = new ResultVo(200, "志愿者招聘修改成功", true, result);
        }else {
            resultVo = new ResultVo(500, "志愿者招聘修改失败", false, null);

        }

        return resultVo;
    }

    @Override
    public ResultVo delete(Long id) {
        int affectedRows = volunteerRecruitmentMapper.deleteByPrimaryKey(id);

        ResultVo resultVo;

        if (affectedRows > 0) {

            resultVo = new ResultVo(200, "志愿者招聘删除成功", true, null);
        }else {
            resultVo = new ResultVo(500, "志愿者招聘删除失败", false, null);

        }

        return resultVo;
    }
}
