package com._520it.wx.web.controller;

import com._520it.wx.domain.Product;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.ProductQueryObject;
import com._520it.wx.service.IProductService;
import com._520it.wx.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zmh on 2017/8/21.
 */
@Controller
public class ProductController extends BaseController {

	@SuppressWarnings("SpringJavaAutowiringInspection")
	@Autowired
	private IProductService service;

	@RequestMapping("/product_view")
	public String product() {
		return "product";
	}

	@RequestMapping("/product_list")
	@ResponseBody
	public PageResult list(ProductQueryObject qo) {

		return service.pageQuery(qo);
	}

	@RequestMapping("/product_listAll")
	@ResponseBody
	public List<Product> listAll() {
		return service.selectAll();
	}

	@RequestMapping("/product_save")
	@ResponseBody
	public AjaxResult save(Product r) {
		try {
			service.insert(r);
			return new AjaxResult(true, "商品保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "商品保存失败");
		}
	}

	@RequestMapping("/product_delete")
	@ResponseBody
	public AjaxResult del(Long id) {
		try {
			service.deleteByPrimaryKey(id);
			return new AjaxResult(true, "商品删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "商品删除失败");
		}
	}

	@RequestMapping("/product_edit")
	@ResponseBody
	public AjaxResult edit(Product product) {
		try {
			service.updateByPrimaryKey(product);
			return new AjaxResult(true, "商品编辑成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "商品编辑失败");
		}
	}

	@RequestMapping("/product_index")
	public String index(ProductQueryObject qo, HttpServletRequest req) {
		PageResult result = service.pageQuery(qo);
		req.setAttribute("result",result);
		return "index";
	}
}
