package com._520it.wx.service.impl;

import com._520it.wx.domain.Product;
import com._520it.wx.mapper.ProductMapper;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.ProductQueryObject;
import com._520it.wx.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cyf on 2017/9/4.
 */
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductMapper mapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Product log) {

		int count = mapper.insert(log);
		return count;
	}

	@Override
	public Product selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Product> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Product log) {
		return mapper.updateByPrimaryKey(log);
	}

	@Override
	public PageResult pageQuery(ProductQueryObject qo) {
		List<Product> listData = mapper.getDataList(qo);
		int totalCount = mapper.getTotalCount(qo);
		return new PageResult(totalCount, listData);
	}

	@Override
	public int insertHeadProduct(Product record) {

		return mapper.insertHeadProduct(record);
	}

	@Override
	public List<Product> getHeadProduct() {
		return mapper.getHeadProduct();
	}
}
