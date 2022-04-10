package com.fc.service.impl;

import com.fc.dao.CarouselMapper;
import com.fc.entity.Carousel;
import com.fc.entity.User;
import com.fc.service.CarouselService;
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
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public ResultVo getlist(Integer pageNum, Integer pageSize, Integer id) {

        List<Carousel> carousels;

        ResultVo resultVo;

        try {
            if (id == null) {
                PageHelper.startPage(pageNum,pageSize);

                carousels = carouselMapper.selectByExample(null);
            }else {
                Carousel carousel = carouselMapper.selectByPrimaryKey(id);

                carousels = new ArrayList<>();
                carousels.add(carousel);
            }

            PageInfo<Carousel> pageInfo = new PageInfo<>(carousels);

            DataVo<Carousel> dataVo = new DataVo<>(pageInfo.getTotal(),carousels,pageNum,pageSize);

            resultVo = new ResultVo(200, "轮播图获取成功", true, dataVo);

        }catch (Exception e) {

            resultVo = new ResultVo(500, "轮播图获取失败", false, null);

        }

        return resultVo;
    }

    @Override
    public ResultVo add(Carousel carousel) {

       //如果没有指定可用，默认为不可用
        if (carousel.getAvailable()== null) {
            carousel.setAvailable(false);
        }
        int affectedRows = carouselMapper.insertSelective(carousel);

        ResultVo resultVo;

        if (affectedRows > 0 ) {
            resultVo = new ResultVo(200,"轮播图添加成功",true, carousel);
        }else {
            resultVo = new ResultVo(500,"轮播图添加失败",false, null);
        }


        return resultVo;
    }

    @Override
    public ResultVo update(Carousel carousel) {
        int affectedRows =  carouselMapper.updateByPrimaryKeySelective(carousel);

        ResultVo resultVo;

        if (affectedRows > 0) {
            Carousel result = carouselMapper.selectByPrimaryKey(carousel.getId());

            resultVo = new ResultVo(200, "轮播图修改成功", true, result);
        }else {
            resultVo = new ResultVo(500, "轮播图修改失败", false, null);

        }

        return resultVo;
    }

    @Override
    public ResultVo delete(Integer id) {
        int affectedRows = carouselMapper.deleteByPrimaryKey(id);

        ResultVo resultVo;

        if (affectedRows > 0) {

            resultVo = new ResultVo(200, "用户删除成功", true, null);
        }else {
            resultVo = new ResultVo(500, "用户删除失败", false, null);

        }

        return resultVo;
    }
}
