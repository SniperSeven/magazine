package com._520it.wx.mapper;

import java.util.List;
import com._520it.wx.domain.Message;
import com._520it.wx.query.MessageQueryObject;
import com._520it.wx.query.QueryObject;

public interface MessageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Message record);

    int updateByPrimaryKey(Message record);
    Message selectByPrimaryKey(Long id);

    List<Message> selectAll();


    int getTotalCount(MessageQueryObject qo);

    List<Message> getListData(MessageQueryObject qo);
}