package com._520it.wx.web.controller;

import com._520it.wx.domain.Material;
import com._520it.wx.domain.Product;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.QueryObject;
import com._520it.wx.service.IMaterialService;
import com._520it.wx.service.IProductService;
import com._520it.wx.util.AjaxResult;
import com._520it.wx.util.HttpUtil;
import com._520it.wx.util.WeixinUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zmh on 2017/8/21.
 */
@Controller
public class MaterialController extends BaseController {

	@Autowired
	private IMaterialService service;

	@Autowired
	private IProductService productService;

	@RequestMapping("/material_view")
	public String material() {
		return "material";
	}

	@RequestMapping("/material_list")
	@ResponseBody
	public PageResult list(QueryObject qo) {

		return service.pageQuery(qo);
	}

	@RequestMapping("/material_listAll")
	@ResponseBody
	public List<Material> listAll() {
		return service.selectAll();
	}

	@RequestMapping("/material_save")
	@ResponseBody
	public AjaxResult save(Material r) {
		try {
			Product product = productService.selectByPrimaryKey(r.getProduct().getId());
			String imageURL = product.getImageURL();
			JSONObject resultJSON = HttpUtil.addMaterialEver(imageURL, "image", WeixinUtil.getAccessToken());
			r.setThumb_media_id((String) resultJSON.get("media_id"));

			service.insert(r);
			return new AjaxResult(true, "客户保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "客户保存失败");
		}
	}

	@RequestMapping("/material_delete")
	@ResponseBody
	public AjaxResult del(Long id) {
		try {
			service.deleteByPrimaryKey(id);
			return new AjaxResult(true, "客户删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "客户删除失败");
		}
	}

	@RequestMapping("/material_edit")
	@ResponseBody
	public AjaxResult edit(Material material) {
		try {
			service.updateByPrimaryKey(material);
			return new AjaxResult(true, "客户编辑成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "客户编辑失败");
		}
	}
}
