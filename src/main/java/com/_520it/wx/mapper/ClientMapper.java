package com._520it.wx.mapper;

import com._520it.wx.domain.Client;
import com._520it.wx.query.ClientQueryObject;

import java.util.List;

public interface ClientMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Client record);

	Client selectByPrimaryKey(Long id);

	List<Client> selectAll();

	int updateByPrimaryKey(Client record);

	List<Client> getDataList(ClientQueryObject qo);

	int getTotalCount(ClientQueryObject qo);

    Client selectByOpenid(String openid);

}