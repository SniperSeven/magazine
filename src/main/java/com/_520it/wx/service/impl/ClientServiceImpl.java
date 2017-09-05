package com._520it.wx.service.impl;

import com._520it.wx.domain.Client;
import com._520it.wx.mapper.ClientMapper;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.ClientQueryObject;
import com._520it.wx.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cyf on 2017/9/4.
 */
@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private ClientMapper mapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Client log) {

		int count = mapper.insert(log);
		return count;
	}

	@Override
	public Client selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Client> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Client log) {
		return mapper.updateByPrimaryKey(log);
	}

	@Override
	public PageResult pageQuery(ClientQueryObject qo) {
		List<Client> listData = mapper.getDataList(qo);
		int totalCount = mapper.getTotalCount(qo);
		return new PageResult(totalCount, listData);
	}


}
