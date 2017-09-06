package com._520it.wx.web.controller;

import com._520it.wx.domain.Material;
import com._520it.wx.domain.Menu;
import com._520it.wx.domain.Product;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.QueryObject;
import com._520it.wx.service.IMaterialService;
import com._520it.wx.service.IMenuService;
import com._520it.wx.service.IProductService;
import com._520it.wx.util.AjaxResult;
import com._520it.wx.util.ContentUtil;
import com._520it.wx.util.HttpUtil;
import com._520it.wx.util.WeixinUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zmh on 2017/8/21.
 */
@Controller
public class MaterialController extends BaseController {

	@Autowired
	private IMaterialService service;

	@Autowired
	private IProductService productService;

	@Autowired
	private IMenuService menuService;

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
	public AjaxResult save(Material r, HttpServletRequest request) {
		try {
			Product product = productService.selectByPrimaryKey(r.getProduct().getId());
			product.setSalePrice(r.getSalePrice());
			productService.updateByPrimaryKey(product);
			System.out.println(r);
			System.out.println(product);
			String image = request.getSession().getServletContext().getRealPath(product.getImageURL());
			String secondImg = request.getSession().getServletContext().getRealPath(product.getSecondImg());
			JSONObject resultJSON = HttpUtil.addMaterialEver(image, "image", WeixinUtil.getAccessToken());
			JSONObject secondJSON = HttpUtil.addMaterialEver(secondImg, "image", WeixinUtil.getAccessToken());
			r.setThumb_media_id((String) resultJSON.get("media_id"));
			r.setContent(ContentUtil.content.replace("PRODUCTNAME",product.getName()).replace("SALEPRICE",r.getSalePrice().toString()).replace("ORIGINPRICE",product.getSalePrice().toString()).replace("TWOPICTURE",(String) resultJSON.get("url")).replace("ONEPICTURE",(String) secondJSON.get("url")).replace("REDIRECTPICTURE","http://zhou.natapp1.cc/product_index.do"));
			/*r.setThumb_media_id("aHnZ8pDnLaUlDRe1ldR4Y0I14ajOJUeihfVakj7hZx4");*/
			List<Material> list = new ArrayList<>();
			list.add(r);
			Map<String,List<Material>> map = new HashMap<>();
			map.put("articles",list);
			String result = HttpUtil.post(WeixinUtil.ADD_NEWS_URL.replace("ACCESS_TOKEN", WeixinUtil.getAccessToken()), JSON.toJSONString(map));
			JSONObject jsonObject = JSON.parseObject(result);
			String  media_id = (String) jsonObject.get("media_id");
			r.setMediaId(media_id);
			/*Menu menu = menuService.selectByName("每日特价");
			menu.setMedia_id(media_id);
			menuService.createMenu();*/
			service.insert(r);
			return new AjaxResult(true, "客户保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "客户保存失败");
		}
	}


	@RequestMapping("/material_apply")
	@ResponseBody
	public AjaxResult apply(Long id) {
		try {
			Material material = service.selectByPrimaryKey(id);
			Product product = material.getProduct();
			product.setSalePrice(material.getSalePrice());
			productService.updateByPrimaryKey(product);
			Menu menu = menuService.selectByName("每日特价");
			String media_id = menu.getMedia_id();
			menu.setMedia_id(material.getMediaId());
			menuService.createMenu();
			return new AjaxResult(true, "客户删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "客户删除失败");
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
