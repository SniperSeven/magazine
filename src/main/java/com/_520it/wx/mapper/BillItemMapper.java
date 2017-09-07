package com._520it.wx.mapper;

import com._520it.wx.domain.BillItem;
import com._520it.wx.domain.Client;
import com._520it.wx.query.BillItemQueryObject;
import com._520it.wx.query.ClientQueryObject;

import java.util.List;

public interface BillItemMapper {
	int deleteByPrimaryKey(Long id);

	int insert(BillItem record);

	BillItem selectByPrimaryKey(Long id);

	List<BillItem> selectAll();
	List<BillItem> selectByBillId(Long id);

	int updateByPrimaryKey(BillItem record);
	List<BillItem> getDataList(BillItemQueryObject qo);

	int getTotalCount(BillItemQueryObject qo);


}