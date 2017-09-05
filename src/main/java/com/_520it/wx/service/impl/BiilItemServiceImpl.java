package com._520it.wx.service.impl;

import com._520it.wx.domain.BillItem;
import com._520it.wx.mapper.BillItemMapper;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.BillItemQueryObject;
import com._520it.wx.service.IBillItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cyf on 2017/9/4.
 */
@Service
public class BiilItemServiceImpl implements IBillItemService {

	@Autowired
	private BillItemMapper mapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(BillItem log) {

		int count = mapper.insert(log);
		return count;
	}

	@Override
	public BillItem selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<BillItem> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(BillItem log) {
		return mapper.updateByPrimaryKey(log);
	}

	@Override
	public PageResult pageQuery(BillItemQueryObject qo) {
		List<BillItem> listData = mapper.getDataList(qo);
		int totalCount = mapper.getTotalCount(qo);
		return new PageResult(totalCount, listData);
	}


}
