package com._520it.wx.mapper;

import com._520it.wx.domain.Bill;
import com._520it.wx.domain.BillItem;
import com._520it.wx.query.BillItemQueryObject;
import com._520it.wx.query.BillQueryObject;

import java.util.List;

public interface BillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Bill record);

    Bill selectByPrimaryKey(Long id);

    List<Bill> selectAll();

    int updateByPrimaryKey(Bill record);

    List<Bill> getDataList(BillQueryObject qo);

    int getTotalCount(BillQueryObject qo);

    Bill selectUnsuccessByCLientId(Long id);
}