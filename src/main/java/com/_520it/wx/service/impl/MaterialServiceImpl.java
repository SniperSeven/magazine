package com._520it.wx.service.impl;

import com._520it.wx.domain.Material;
import com._520it.wx.mapper.MaterialMapper;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.QueryObject;
import com._520it.wx.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cyf on 2017/9/4.
 */
@Service
public class MaterialServiceImpl implements IMaterialService {

	@Autowired
	private MaterialMapper mapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Material log) {

		int count = mapper.insert(log);
		return count;
	}

	@Override
	public Material selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Material> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Material log) {
		return mapper.updateByPrimaryKey(log);
	}

	@Override
	public PageResult pageQuery(QueryObject qo) {
		List<Material> listData = mapper.getDataList(qo);
		int totalCount = mapper.getTotalCount(qo);
		return new PageResult(totalCount, listData);
	}

}
