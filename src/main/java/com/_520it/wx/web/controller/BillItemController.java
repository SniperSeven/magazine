package com._520it.wx.web.controller;

import com._520it.wx.domain.BillItem;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.BillItemQueryObject;
import com._520it.wx.service.IBillItemService;
import com._520it.wx.util.AjaxResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zmh on 2017/8/21.
 */
@Controller
public class BillItemController extends BaseController {

	@SuppressWarnings("SpringJavaAutowiringInspection")
	@Autowired
	private IBillItemService service;

	@RequestMapping("/billItem_view")
	public String billItem() {
		return "billItem";
	}

	@RequestMapping("/billItem_list")
	@ResponseBody
	public PageResult list(BillItemQueryObject qo) {

		return service.pageQuery(qo);
	}

	@RequestMapping("/billItem_listAll")
	@ResponseBody
	public List<BillItem> listAll() {
		return service.selectAll();
	}

	@RequestMapping("/billItem_save")
	@ResponseBody
	public AjaxResult save(BillItem r) {
		try {
			service.insert(r);
			return new AjaxResult(true, "订单明细保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "订单明细保存失败");
		}
	}

	@RequestMapping("/billItem_delete")
	@ResponseBody
	public AjaxResult del(Long id) {
		try {
			service.deleteByPrimaryKey(id);
			return new AjaxResult(true, "订单明细删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "订单明细删除失败");
		}
	}

	@RequestMapping("/billItem_edit")
	@ResponseBody
	public AjaxResult edit(BillItem billItem) {
		try {
			service.updateByPrimaryKey(billItem);
			return new AjaxResult(true, "订单明细编辑成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "订单明细编辑失败");
		}
	}
}
