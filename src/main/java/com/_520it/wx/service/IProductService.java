package com._520it.wx.service;

import com._520it.wx.domain.Product;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.ProductQueryObject;

import java.util.List;

/**
 * Created by cyf on 2017/9/4.
 */
public interface IProductService {
	int deleteByPrimaryKey(Long id);

	int insert(Product record);

	Product selectByPrimaryKey(Long id);

	List<Product> selectAll();

	int updateByPrimaryKey(Product record);

	PageResult pageQuery(ProductQueryObject qo);
}
