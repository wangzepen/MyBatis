package com.fc.service.impl;

import com.fc.dao.PoorMapper;
import com.fc.entity.MessageBoard;
import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
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
public class PoorServiceImpl implements PoorService {
    @Autowired
    private PoorMapper poorMapper;

    @Override
    public ResultVo click(Long id, Date lastClickTime) {
        return null;
    }

    @Override
    public ResultVo getlist(Integer pageNum, Integer pageSize, Long id) {
        List<PoorWithBLOBs> poor;

        ResultVo resultVo;

        try {
            if (id == null) {
                PageHelper.startPage(pageNum,pageSize);

                poor = poorMapper.selectByExampleWithBLOBs(null);
            }else {
                PoorWithBLOBs poorWithBLOBs = poorMapper.selectByPrimaryKey(id);

                poor = new ArrayList<>();
                poor.add(poorWithBLOBs);


                // 如果调用了findById，应该对点击量进行加1操作
                click(poorWithBLOBs.getId(), null);
            }

            PageInfo<PoorWithBLOBs> pageInfo = new PageInfo<>(poor);

            DataVo<PoorWithBLOBs> dataVo = new DataVo<>(pageInfo.getTotal(),poor,pageNum,pageSize);

            resultVo = new ResultVo(200, "贫困户信息获取成功", true, dataVo);

        }catch (Exception e) {

            resultVo = new ResultVo(500, "贫困户信息获取失败", false, null);

        }

        return resultVo;
    }

    @Override
    public ResultVo add(PoorWithBLOBs poor) {
        if (poor.getCreateTime()== null) {
            poor.setCreateTime(new Date());
        }
        int affectedRows = poorMapper.insertSelective(poor);

        ResultVo resultVo;

        if (affectedRows > 0 ) {
            resultVo = new ResultVo(200,"贫困户信息添加成功",true, poor);
        }else {
            resultVo = new ResultVo(500,"贫困户信息添加失败",false, null);
        }


        return resultVo;
    }

    @Override
    public ResultVo update(PoorWithBLOBs poor) {

        int affectedRows =  poorMapper.updateByPrimaryKeySelective(poor);

        ResultVo resultVo;

        if (affectedRows > 0) {
            Poor result = poorMapper.selectByPrimaryKey(poor.getId());

            resultVo = new ResultVo(200, "贫困户信息修改成功", true, result);
        }else {
            resultVo = new ResultVo(500, "贫困户信息修改失败", false, null);

        }

        return resultVo;
    }

    @Override
    public ResultVo delete(Long id) {
        int affectedRows = poorMapper.deleteByPrimaryKey(id);

        ResultVo resultVo;

        if (affectedRows > 0) {

            resultVo = new ResultVo(200, "贫困户信息删除成功", true, null);
        }else {
            resultVo = new ResultVo(500, "贫困户信息删除失败", false, null);

        }

        return resultVo;
    }
}
