package com._520it.wx.service;

import com._520it.wx.domain.Client;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.ClientQueryObject;

import java.util.List;

/**
 * Created by cyf on 2017/9/4.
 */
public interface IClientService {
	int deleteByPrimaryKey(Long id);

	int insert(Client record);

	Client selectByPrimaryKey(Long id);

	List<Client> selectAll();

	int updateByPrimaryKey(Client record);

	PageResult pageQuery(ClientQueryObject qo);
}
