package com._520it.wx.mapper;

import com._520it.wx.domain.Product;
import com._520it.wx.query.ProductQueryObject;

import java.util.List;

public interface ProductMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Product record);

	Product selectByPrimaryKey(Long id);

	List<Product> selectAll();

	int updateByPrimaryKey(Product record);

	List<Product> getDataList(ProductQueryObject qo);

	int getTotalCount(ProductQueryObject qo);
}