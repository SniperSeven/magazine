package com._520it.wx.service;

import com._520it.wx.domain.BillItem;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.BillItemQueryObject;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cyf on 2017/9/4.
 */
public interface IBillItemService {
	int deleteByPrimaryKey(Long id);

	int insert(BillItem record);

	BillItem selectByPrimaryKey(Long id);

	List<BillItem> selectAll();

	int updateByPrimaryKey(BillItem record);

	PageResult pageQuery(BillItemQueryObject qo);
}
