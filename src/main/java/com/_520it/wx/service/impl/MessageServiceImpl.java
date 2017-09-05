package com._520it.wx.service.impl;

import com._520it.wx.domain.Message;
import com._520it.wx.domain.Salechart;
import com._520it.wx.mapper.MessageMapper;
import com._520it.wx.mapper.SalechartMapper;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.MessageQueryObject;
import com._520it.wx.query.QueryObject;
import com._520it.wx.service.IMessageService;
import com._520it.wx.service.ISalechartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by 76585 on 2017/9/4.
 */
@Service
public class MessageServiceImpl implements IMessageService{

    @Autowired
    private MessageMapper mapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Message record) {
        return mapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Message record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public Message selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Message> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public PageResult pageQuery(MessageQueryObject qo) {
        int totalCount = mapper.getTotalCount(qo);
        if (totalCount==0){
            return new PageResult(0, Collections.EMPTY_LIST);
        }
        List<Message> listData = mapper.getListData(qo);
        return new PageResult(totalCount,listData);
    }
}
