package com._520it.wx.service;

import com._520it.wx.domain.Message;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.MessageQueryObject;
import com._520it.wx.query.QueryObject;

import java.util.List;

/**
 * Created by 76585 on 2017/9/4.
 */
public interface IMessageService {

    int deleteByPrimaryKey(Long id);

    int insert(Message record);

    int updateByPrimaryKey(Message record);

    Message selectByPrimaryKey(Long id);

    List<Message> selectAll();

    PageResult pageQuery(MessageQueryObject qo);
}
