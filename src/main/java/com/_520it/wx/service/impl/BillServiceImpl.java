package com._520it.wx.service.impl;

import com._520it.wx.domain.Bill;
import com._520it.wx.domain.BillItem;
import com._520it.wx.domain.Salechart;
import com._520it.wx.mapper.BillMapper;
import com._520it.wx.mapper.SalechartMapper;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.BillQueryObject;
import com._520it.wx.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by cyf on 2017/9/4.
 */
@Service
public class BillServiceImpl implements IBillService {

	@Autowired
	private BillMapper mapper;

	@Autowired
	private SalechartMapper salechartMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Bill log) {
		Salechart salechart = new Salechart();
		salechart.setSaletime(log.getSaleDate());
		salechart.setSn(log.getSn());
		//通过订单计算出销售记录表的总金额和总数量
		BigDecimal totalPrice = BigDecimal.ZERO;
		BigDecimal totalNumber = BigDecimal.ZERO;
		BigDecimal totalCostPrice = BigDecimal.ZERO;
		List<BillItem> items = log.getItems();
		for (BillItem item : items) {
			//获取商品的销售价格
			BigDecimal salePrice = item.getProduct().getSalePrice();
			//销售数量
			BigDecimal number = item.getNumber();
			//精确精度，四舍五入
			BigDecimal amount = salePrice.multiply(number).setScale(2, BigDecimal.ROUND_HALF_UP);
			//计算金额小计
			item.setSmallAccount(amount);
			totalPrice = totalPrice.add(amount);
			totalNumber = totalNumber.add(number);

			BigDecimal costPrice = item.getProduct().getCostPrice();
			totalCostPrice.add(costPrice.multiply(number).setScale(2, BigDecimal.ROUND_HALF_UP));
		}
		log.setTotalPrice(totalPrice);
		log.setTotalNumber(totalNumber);
		log.setCostPrice(totalCostPrice);
		int count = mapper.insert(log);
		salechart.setCostprice(totalCostPrice);
		salechart.setSaleprice(totalPrice);
		salechart.setNumber(totalNumber);
		salechart.setProfit(totalPrice.subtract(totalCostPrice).setScale(2,BigDecimal.ROUND_HALF_UP));
		salechartMapper.insert(salechart);
		return count;
	}

	@Override
	public Bill selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Bill> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Bill log) {
		return mapper.updateByPrimaryKey(log);
	}

	@Override
	public PageResult pageQuery(BillQueryObject qo) {
		List<Bill> listData = mapper.getDataList(qo);
		int totalCount = mapper.getTotalCount(qo);
		return new PageResult(totalCount, listData);
	}

	@Override
	public int delivery(Long id) {

		return mapper.delivery(id);
	}


}
