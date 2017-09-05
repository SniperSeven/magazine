package com._520it.wx.service;

import com._520it.wx.domain.Client;
import com._520it.wx.domain.Material;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.ClientQueryObject;
import com._520it.wx.query.QueryObject;

import java.util.List;

/**
 * Created by cyf on 2017/9/4.
 */
public interface IMaterialService {
	int deleteByPrimaryKey(Long id);

	int insert(Material record);

	Material selectByPrimaryKey(Long id);

	List<Material> selectAll();

	int updateByPrimaryKey(Material record);

	PageResult pageQuery(QueryObject qo);

}
