package com._520it.wx.service;

import com._520it.wx.domain.Bill;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.BillQueryObject;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cyf on 2017/9/4.
 */
public interface IBillService {
	int deleteByPrimaryKey(Long id);

	int insert(Bill record);

	Bill selectByPrimaryKey(Long id);

	List<Bill> selectAll();

	int updateByPrimaryKey(Bill record);

	PageResult pageQuery(BillQueryObject qo);

	Bill selectUnsuccessByCLientId(Long id);
}
