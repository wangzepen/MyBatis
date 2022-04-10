package com.fc.service.impl;

import com.fc.dao.MessageBoardMapper;
import com.fc.entity.Collection;
import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MsgboardService;
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
public class MsgboardServiceImpl implements MsgboardService {
    @Autowired
    private MessageBoardMapper messageBoardMapper;

    @Override
    public ResultVo getlist(Integer pageNum, Integer pageSize, Long id) {
        List<MessageBoard> messageBoards;

        ResultVo resultVo;

        try {
            if (id == null) {
                PageHelper.startPage(pageNum,pageSize);

                messageBoards = messageBoardMapper.selectByExample(null);
            }else {
                MessageBoard messageBoard = messageBoardMapper.selectByPrimaryKey(id);

                messageBoards = new ArrayList<>();
                messageBoards.add(messageBoard);
            }

            PageInfo<MessageBoard> pageInfo = new PageInfo<>(messageBoards);

            DataVo<MessageBoard> dataVo = new DataVo<>(pageInfo.getTotal(),messageBoards,pageNum,pageSize);

            resultVo = new ResultVo(200, "留言板获取成功", true, dataVo);

        }catch (Exception e) {

            resultVo = new ResultVo(500, "留言板获取失败", false, null);

        }

        return resultVo;
    }

    @Override
    public ResultVo add(MessageBoardWithBLOBs messageBoard) {
        if (messageBoard.getCreateTime()== null) {
            messageBoard.setCreateTime(new Date());
        }
        int affectedRows = messageBoardMapper.insertSelective(messageBoard);

        ResultVo resultVo;

        if (affectedRows > 0 ) {
            resultVo = new ResultVo(200,"留言板添加成功",true, messageBoard);
        }else {
            resultVo = new ResultVo(500,"留言板添加失败",false, null);
        }


        return resultVo;
    }

    @Override
    public ResultVo update(MessageBoardWithBLOBs messageBoard) {
        int affectedRows =  messageBoardMapper.updateByPrimaryKeySelective(messageBoard);

        ResultVo resultVo;

        if (affectedRows > 0) {
            MessageBoard result = messageBoardMapper.selectByPrimaryKey(messageBoard.getId());

            resultVo = new ResultVo(200, "留言板修改成功", true, result);
        }else {
            resultVo = new ResultVo(500, "留言板修改失败", false, null);

        }

        return resultVo;
    }

    @Override
    public ResultVo delete(Long id) {
        int affectedRows = messageBoardMapper.deleteByPrimaryKey(id);

        ResultVo resultVo;

        if (affectedRows > 0) {

            resultVo = new ResultVo(200, "留言板删除成功", true, null);
        }else {
            resultVo = new ResultVo(500, "留言板删除失败", false, null);

        }

        return resultVo;
    }
}
